package pl.piasta.acmanagement.api.acunits.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AddUnitRequest implements Serializable {

    @NotBlank
    @Size(min = 2, max = 100)
    private String manufacturer;

    @NotBlank
    @Size(min = 2, max = 100)
    private String productName;

    @NotNull
    @Min(1)
    private Integer voltage;

    @NotNull
    @Min(1)
    private Integer current;
}
