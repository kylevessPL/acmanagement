package pl.piasta.acmanagement.api.acunits;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.acmanagement.api.acunits.model.AddUnitRequest;
import pl.piasta.acmanagement.api.mapper.AcUnitMapper;
import pl.piasta.acmanagement.api.misc.ResourceCreatedResponse;
import pl.piasta.acmanagement.domain.acunits.model.AcUnit;
import pl.piasta.acmanagement.domain.acunits.model.AcUnitsService;
import pl.piasta.acmanagement.dto.acunits.AcUnitResponse;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/units")
@Validated
@RequiredArgsConstructor
public class AcUnitsServiceController {

    private final AcUnitsService service;
    private final AcUnitMapper mapper;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResourceCreatedResponse addUnit(@RequestBody @Valid AddUnitRequest request) {
        AcUnit unit = mapper.mapToAcUnit(request);
        Long id = service.addUnit(unit);
        return new ResourceCreatedResponse(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AcUnitResponse getUnit(@PathVariable @Min(1) Long id) {
        AcUnit unit = service.getUnitById(id);
        return mapper.mapToResponse(unit);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AcUnitResponse> getAllUnits() {
        List<AcUnit> unitList = service.getAllUnits();
        return mapper.mapToResponseList(unitList);
    }
}
