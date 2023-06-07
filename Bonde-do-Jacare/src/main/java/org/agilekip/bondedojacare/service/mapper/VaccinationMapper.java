package org.agilekip.bondedojacare.service.mapper;

import org.agilekip.bondedojacare.domain.*;
import org.agilekip.bondedojacare.service.dto.VaccinationDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Vaccination} and its DTO {@link VaccinationDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VaccinationMapper extends EntityMapper<VaccinationDTO, Vaccination> {}
