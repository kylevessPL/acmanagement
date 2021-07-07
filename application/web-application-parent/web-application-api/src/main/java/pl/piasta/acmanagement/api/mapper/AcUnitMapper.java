package pl.piasta.acmanagement.api.mapper;

import org.mapstruct.Mapper;
import pl.piasta.acmanagement.api.acunits.model.AddUnitRequest;
import pl.piasta.acmanagement.domain.acunits.model.AcUnit;
import pl.piasta.acmanagement.dto.acunits.AcUnitResponse;

import java.util.List;

@Mapper
public interface AcUnitMapper {

    AcUnit mapToAcUnit(AddUnitRequest request);
    AcUnitResponse mapToResponse(AcUnit unit);
    List<AcUnitResponse> mapToResponseList(List<AcUnit> unitList);
}
