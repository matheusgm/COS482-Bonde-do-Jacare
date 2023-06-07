package org.agilekip.bondedojacare.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.agilekip.bondedojacare.repository.VaccinationRepository;
import org.agilekip.bondedojacare.service.VaccinationService;
import org.agilekip.bondedojacare.service.dto.VaccinationDTO;
import org.agilekip.bondedojacare.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.agilekip.bondedojacare.domain.Vaccination}.
 */
@RestController
@RequestMapping("/api")
public class VaccinationResource {

    private final Logger log = LoggerFactory.getLogger(VaccinationResource.class);

    private final VaccinationService vaccinationService;

    private final VaccinationRepository vaccinationRepository;

    public VaccinationResource(VaccinationService vaccinationService, VaccinationRepository vaccinationRepository) {
        this.vaccinationService = vaccinationService;
        this.vaccinationRepository = vaccinationRepository;
    }

    /**
     * {@code GET  /vaccinations} : get all the vaccinations.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of vaccinations in body.
     */
    @GetMapping("/vaccinations")
    public List<VaccinationDTO> getAllVaccinations() {
        log.debug("REST request to get all Vaccinations");
        return vaccinationService.findAll();
    }

    /**
     * {@code GET  /vaccinations/:id} : get the "id" vaccination.
     *
     * @param id the id of the vaccinationDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the vaccinationDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/vaccinations/{id}")
    public ResponseEntity<VaccinationDTO> getVaccination(@PathVariable Long id) {
        log.debug("REST request to get Vaccination : {}", id);
        Optional<VaccinationDTO> vaccinationDTO = vaccinationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(vaccinationDTO);
    }
}
