package pl.piasta.acmanagement.domain.acsystems;

import pl.piasta.acmanagement.domain.acsystems.model.AcSystem;
import pl.piasta.acmanagement.domain.acsystems.model.AcSystemFull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AcSystemsRepository {

    Long add(AcSystem unit);
    boolean remove(Long id);
    boolean updateNextMaintainance(Long id, LocalDateTime date);
    boolean updateNotificationsStatus(Long id, boolean enabled);
    Optional<AcSystemFull> get(Long id);
    List<AcSystem> getAll();
}
