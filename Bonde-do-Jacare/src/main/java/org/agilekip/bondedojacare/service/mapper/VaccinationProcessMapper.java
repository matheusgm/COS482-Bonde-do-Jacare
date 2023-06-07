package org.agilekip.bondedojacare.service.mapper;

import org.agilekip.bondedojacare.domain.*;
import org.agilekip.bondedojacare.service.dto.VaccinationProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link VaccinationProcess} and its DTO {@link VaccinationProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, VaccinationMapper.class })
public interface VaccinationProcessMapper extends EntityMapper<VaccinationProcessDTO, VaccinationProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "vaccination", source = "vaccination")
    VaccinationProcessDTO toDto(VaccinationProcess s);
}
