package pl.piasta.acmanagement.domain.acunits;

import pl.piasta.acmanagement.domain.acunits.model.AcUnit;

import java.util.List;
import java.util.Optional;

public interface AcUnitsRepository {

    Long add(AcUnit unit);
    void update(AcUnit unit);
    Optional<AcUnit> get(Long id);
    List<AcUnit> getAll();
}
