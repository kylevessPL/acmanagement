package pl.piasta.acmanagement.domain.acsystems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class AcSystem {

    private Long id;
    private Long unitId;
    private LocalDateTime nextMaintainance;
    private boolean notified;
    private Long customerId;
}
