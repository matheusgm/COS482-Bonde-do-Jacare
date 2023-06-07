package org.agilekip.bondedojacare.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.agilekip.bondedojacare.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class VaccinationDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(VaccinationDTO.class);
        VaccinationDTO vaccinationDTO1 = new VaccinationDTO();
        vaccinationDTO1.setId(1L);
        VaccinationDTO vaccinationDTO2 = new VaccinationDTO();
        assertThat(vaccinationDTO1).isNotEqualTo(vaccinationDTO2);
        vaccinationDTO2.setId(vaccinationDTO1.getId());
        assertThat(vaccinationDTO1).isEqualTo(vaccinationDTO2);
        vaccinationDTO2.setId(2L);
        assertThat(vaccinationDTO1).isNotEqualTo(vaccinationDTO2);
        vaccinationDTO1.setId(null);
        assertThat(vaccinationDTO1).isNotEqualTo(vaccinationDTO2);
    }
}
