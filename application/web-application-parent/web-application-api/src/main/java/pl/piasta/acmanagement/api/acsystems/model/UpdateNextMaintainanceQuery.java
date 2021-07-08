package pl.piasta.acmanagement.api.acsystems.model;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class UpdateNextMaintainanceQuery implements Serializable {

    @NotNull
    @Min(1)
    private Long id;

    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime nextMaintainance;
}
