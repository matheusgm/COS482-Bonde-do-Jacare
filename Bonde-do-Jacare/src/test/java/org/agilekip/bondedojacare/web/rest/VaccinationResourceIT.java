package org.agilekip.bondedojacare.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.agilekip.bondedojacare.IntegrationTest;
import org.agilekip.bondedojacare.domain.Vaccination;
import org.agilekip.bondedojacare.repository.VaccinationRepository;
import org.agilekip.bondedojacare.service.dto.VaccinationDTO;
import org.agilekip.bondedojacare.service.mapper.VaccinationMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link VaccinationResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class VaccinationResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_BIRTH_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BIRTH_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_JOB = "AAAAAAAAAA";
    private static final String UPDATED_JOB = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_AND_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_AND_TIME = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_VACCINE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_VACCINE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_APPLICATOR = "AAAAAAAAAA";
    private static final String UPDATED_APPLICATOR = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/vaccinations";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Autowired
    private VaccinationMapper vaccinationMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restVaccinationMockMvc;

    private Vaccination vaccination;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Vaccination createEntity(EntityManager em) {
        Vaccination vaccination = new Vaccination()
            .name(DEFAULT_NAME)
            .birthDate(DEFAULT_BIRTH_DATE)
            .job(DEFAULT_JOB)
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .address(DEFAULT_ADDRESS)
            .dateAndTime(DEFAULT_DATE_AND_TIME)
            .vaccineType(DEFAULT_VACCINE_TYPE)
            .applicator(DEFAULT_APPLICATOR);
        return vaccination;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Vaccination createUpdatedEntity(EntityManager em) {
        Vaccination vaccination = new Vaccination()
            .name(UPDATED_NAME)
            .birthDate(UPDATED_BIRTH_DATE)
            .job(UPDATED_JOB)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .address(UPDATED_ADDRESS)
            .dateAndTime(UPDATED_DATE_AND_TIME)
            .vaccineType(UPDATED_VACCINE_TYPE)
            .applicator(UPDATED_APPLICATOR);
        return vaccination;
    }

    @BeforeEach
    public void initTest() {
        vaccination = createEntity(em);
    }

    @Test
    @Transactional
    void getAllVaccinations() throws Exception {
        // Initialize the database
        vaccinationRepository.saveAndFlush(vaccination);

        // Get all the vaccinationList
        restVaccinationMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(vaccination.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].birthDate").value(hasItem(DEFAULT_BIRTH_DATE.toString())))
            .andExpect(jsonPath("$.[*].job").value(hasItem(DEFAULT_JOB)))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER)))
            .andExpect(jsonPath("$.[*].address").value(hasItem(DEFAULT_ADDRESS)))
            .andExpect(jsonPath("$.[*].dateAndTime").value(hasItem(DEFAULT_DATE_AND_TIME.toString())))
            .andExpect(jsonPath("$.[*].vaccineType").value(hasItem(DEFAULT_VACCINE_TYPE)))
            .andExpect(jsonPath("$.[*].applicator").value(hasItem(DEFAULT_APPLICATOR)));
    }

    @Test
    @Transactional
    void getVaccination() throws Exception {
        // Initialize the database
        vaccinationRepository.saveAndFlush(vaccination);

        // Get the vaccination
        restVaccinationMockMvc
            .perform(get(ENTITY_API_URL_ID, vaccination.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(vaccination.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.birthDate").value(DEFAULT_BIRTH_DATE.toString()))
            .andExpect(jsonPath("$.job").value(DEFAULT_JOB))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER))
            .andExpect(jsonPath("$.address").value(DEFAULT_ADDRESS))
            .andExpect(jsonPath("$.dateAndTime").value(DEFAULT_DATE_AND_TIME.toString()))
            .andExpect(jsonPath("$.vaccineType").value(DEFAULT_VACCINE_TYPE))
            .andExpect(jsonPath("$.applicator").value(DEFAULT_APPLICATOR));
    }

    @Test
    @Transactional
    void getNonExistingVaccination() throws Exception {
        // Get the vaccination
        restVaccinationMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
