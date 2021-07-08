package pl.piasta.acmanagement.infrastructure.acunits;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.piasta.acmanagement.domain.acunits.AcUnitsRepository;
import pl.piasta.acmanagement.domain.acunits.model.AcUnit;
import pl.piasta.acmanagement.infrastructure.dao.AcUnitsDao;
import pl.piasta.acmanagement.infrastructure.mapper.AcUnitsEntityMapper;
import pl.piasta.acmanagement.infrastructure.model.AcUnitsEntity;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AcUnitsRepositoryImpl implements AcUnitsRepository {

    private final AcUnitsDao dao;
    private final AcUnitsEntityMapper mapper;

    @Override
    @Transactional
    public Long add(AcUnit unit) {
        AcUnitsEntity entity = new AcUnitsEntity();
        updateEntity(entity, unit);
        return dao.save(entity).getId();
    }

    @Override
    @Transactional
    public void update(AcUnit unit) {
        AcUnitsEntity entity = new AcUnitsEntity();
        updateEntity(entity, unit);
        dao.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AcUnit> get(Long id) {
        Optional<AcUnitsEntity> entity = dao.findById(id);
        return mapper.mapToAcUnitOptional(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AcUnit> getAll() {
        List<AcUnitsEntity> entityList = dao.findAll();
        return mapper.mapToAcUnitList(entityList);
    }

    void updateEntity(AcUnitsEntity entity, AcUnit unit) {
        entity.setId(unit.getId());
        entity.setManufacturer(unit.getManufacturer());
        entity.setProductName(unit.getProductName());
        entity.setCurrent(unit.getCurrent());
        entity.setVoltage(unit.getVoltage());
    }
}
