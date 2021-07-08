package pl.piasta.acmanagement.infrastructure.acsystems;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.piasta.acmanagement.domain.acsystems.AcSystemsRepository;
import pl.piasta.acmanagement.domain.acsystems.model.AcSystem;
import pl.piasta.acmanagement.domain.acsystems.model.AcSystemFull;
import pl.piasta.acmanagement.infrastructure.dao.AcSystemsDao;
import pl.piasta.acmanagement.infrastructure.mapper.AcSystemsEntityMapper;
import pl.piasta.acmanagement.infrastructure.model.AcSystemsEntity;
import pl.piasta.acmanagement.infrastructure.model.AcUnitsEntity;
import pl.piasta.acmanagement.infrastructure.model.CustomersEntity;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AcSystemsRepositoryImpl implements AcSystemsRepository {

    private final AcSystemsDao dao;
    private final EntityManager entityManager;
    private final AcSystemsEntityMapper mapper;

    @Override
    @Transactional
    public Long add(AcSystem unit) {
        AcSystemsEntity entity = new AcSystemsEntity();
        updateEntity(entity, unit);
        return dao.save(entity).getId();
    }

    @Override
    @Transactional
    public boolean remove(Long id) {
        try {
            dao.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean updateNextMaintainance(Long id, LocalDateTime date) {
        return dao.findById(id).map(entity -> {
            entity.setNextMaintainance(date);
            dao.save(entity);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional
    public boolean updateNotificationsStatus(Long id, boolean enabled) {
        return dao.findById(id).map(entity -> {
            entity.setNotifications(enabled);
            dao.save(entity);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AcSystemFull> get(Long id) {
        Optional<AcSystemsEntity> entity = dao.findById(id);
        return mapper.mapToAcSystemFullOptional(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AcSystem> getAll() {
        List<AcSystemsEntity> entityList = dao.findAll();
        return mapper.mapToAcSystemList(entityList);
    }

    void updateEntity(AcSystemsEntity entity, AcSystem system) {
        entity.setId(system.getId());
        entity.setNextMaintainance(system.getNextMaintainance());
        entity.setNotifications(system.isNotified());
        entity.setCustomer(entityManager.find(CustomersEntity.class, system.getCustomerId()));
        entity.setUnit(entityManager.find(AcUnitsEntity.class, system.getUnitId()));
    }
}
