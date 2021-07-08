package pl.piasta.acmanagement.domain.acsystems;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.piasta.acmanagement.domain.acsystems.model.AcSystem;
import pl.piasta.acmanagement.domain.acsystems.model.AcSystemFull;
import pl.piasta.acmanagement.domain.acunits.AcUnitsRepository;
import pl.piasta.acmanagement.domain.customers.CustomersRepository;
import pl.piasta.acmanagement.domain.misc.ErrorCode;
import pl.piasta.acmanagement.domain.misc.MyException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AcSystemsServiceImpl implements AcSystemsService {

    private final AcSystemsRepository acSystemsRepository;
    private final AcUnitsRepository acUnitsRepository;
    private final CustomersRepository customersRepository;

    @Override
    @Transactional
    public Long addSystem(AcSystem system) {
        if (!acUnitsRepository.exists(system.getUnitId())) {
            throw new MyException(ErrorCode.UNIT_NOT_EXISTS);
        }
        if (!customersRepository.exists(system.getCustomerId())) {
            throw new MyException(ErrorCode.CUSTOMER_NOT_EXISTS);
        }
        return acSystemsRepository.add(system);
    }

    @Override
    @Transactional
    public void removeSystemById(Long id) {
        if (!acSystemsRepository.remove(id)) {
            throw new MyException(ErrorCode.SYSTEM_NOT_EXISTS);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public AcSystemFull getSystemById(Long id) {
        return acSystemsRepository.get(id)
                .orElseThrow(() -> new MyException(ErrorCode.SYSTEM_NOT_EXISTS));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AcSystem> getAllSystems() {
        return acSystemsRepository.getAll();
    }

    @Override
    @Transactional
    public void setNextMaintainance(Long id, LocalDateTime date) {
        if (!acSystemsRepository.updateNextMaintainance(id, date)) {
            throw new MyException(ErrorCode.SYSTEM_NOT_EXISTS);
        }
    }

    @Override
    @Transactional
    public void setNotifications(Long id, boolean enabled) {
        if (!acSystemsRepository.updateNotificationsStatus(id, enabled)) {
            throw new MyException(ErrorCode.SYSTEM_NOT_EXISTS);
        }
    }
}