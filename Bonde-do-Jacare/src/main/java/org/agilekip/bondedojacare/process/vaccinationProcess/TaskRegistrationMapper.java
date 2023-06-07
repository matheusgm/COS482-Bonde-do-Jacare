package org.agilekip.bondedojacare.process.vaccinationProcess;

import org.agilekip.bondedojacare.domain.Vaccination;
import org.agilekip.bondedojacare.domain.VaccinationProcess;
import org.agilekip.bondedojacare.service.dto.VaccinationDTO;
import org.agilekip.bondedojacare.service.dto.VaccinationProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskRegistrationMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    VaccinationProcessDTO toVaccinationProcessDTO(VaccinationProcess vaccinationProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "job", source = "job")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "address", source = "address")
    VaccinationDTO toVaccinationDTO(Vaccination vaccination);
}
