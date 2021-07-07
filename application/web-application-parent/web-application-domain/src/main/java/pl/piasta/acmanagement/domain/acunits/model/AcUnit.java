package pl.piasta.acmanagement.domain.acunits.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class AcUnit {

    private final String manufacturer;
    private final String productName;
    private final Integer voltage;
    private final Integer current;
}
