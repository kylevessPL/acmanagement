package pl.piasta.acmanagement.domain.acunits.model;

import java.util.List;

public interface AcUnitsService {

    Long addUnit(AcUnit unit);
    void updateUnit(AcUnit unit);
    AcUnit getUnitById(Long id);
    List<AcUnit> getAllUnits();
}
