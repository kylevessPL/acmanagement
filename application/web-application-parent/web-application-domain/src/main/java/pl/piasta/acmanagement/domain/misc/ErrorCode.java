package pl.piasta.acmanagement.domain.misc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    VALIDATION_FAILED("V06", "Validation failed");

    private final String code;
    private final String message;
}
