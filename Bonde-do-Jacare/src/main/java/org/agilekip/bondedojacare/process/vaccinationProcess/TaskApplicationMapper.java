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
public interface TaskApplicationMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    VaccinationProcessDTO toVaccinationProcessDTO(VaccinationProcess vaccinationProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "job", source = "job")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "dateAndTime", source = "dateAndTime")
    @Mapping(target = "vaccineType", source = "vaccineType")
    @Mapping(target = "applicator", source = "applicator")
    VaccinationDTO toVaccinationDTO(Vaccination vaccination);
}
