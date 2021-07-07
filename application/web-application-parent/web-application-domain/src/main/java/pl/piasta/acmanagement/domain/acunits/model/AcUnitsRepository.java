package pl.piasta.acmanagement.domain.acunits.model;

import java.util.List;
import java.util.Optional;

public interface AcUnitsRepository {

    Long add(AcUnit unit);
    void update(AcUnit unit);
    Optional<AcUnit> get(Long id);
    List<AcUnit> getAll();
}
