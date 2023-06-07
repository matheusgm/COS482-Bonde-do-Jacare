package org.agilekip.bondedojacare.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VaccinationMapperTest {

    private VaccinationMapper vaccinationMapper;

    @BeforeEach
    public void setUp() {
        vaccinationMapper = new VaccinationMapperImpl();
    }
}
