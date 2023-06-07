package org.agilekip.bondedojacare.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.agilekip.bondedojacare.service.VaccinationProcessService;
import org.agilekip.bondedojacare.service.dto.VaccinationProcessDTO;
import org.agilekip.bondedojacare.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.agilekip.bondedojacare.domain.VaccinationProcess}.
 */
@RestController
@RequestMapping("/api")
public class VaccinationProcessResource {

    private final Logger log = LoggerFactory.getLogger(VaccinationProcessResource.class);

    private static final String ENTITY_NAME = "vaccinationProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VaccinationProcessService vaccinationProcessService;

    public VaccinationProcessResource(VaccinationProcessService vaccinationProcessService) {
        this.vaccinationProcessService = vaccinationProcessService;
    }

    /**
     * {@code POST  /vaccination-processes} : Create a new vaccinationProcess.
     *
     * @param vaccinationProcessDTO the vaccinationProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new vaccinationProcessDTO, or with status {@code 400 (Bad Request)} if the vaccinationProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/vaccination-processes")
    public ResponseEntity<VaccinationProcessDTO> create(@RequestBody VaccinationProcessDTO vaccinationProcessDTO)
        throws URISyntaxException {
        log.debug("REST request to save VaccinationProcess : {}", vaccinationProcessDTO);
        if (vaccinationProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new vaccinationProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VaccinationProcessDTO result = vaccinationProcessService.create(vaccinationProcessDTO);
        return ResponseEntity
            .created(new URI("/api/vaccination-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /vaccination-processes} : get all the vaccinationProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of vaccinationProcesss in body.
     */
    @GetMapping("/vaccination-processes")
    public List<VaccinationProcessDTO> getAllVaccinationProcesss() {
        log.debug("REST request to get all VaccinationProcesss");
        return vaccinationProcessService.findAll();
    }

    /**
     * {@code GET  /vaccination-processes/:id} : get the "id" vaccinationProcess.
     *
     * @param processInstanceId the id of the vaccinationProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the vaccinationProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/vaccination-processes/{processInstanceId}")
    public ResponseEntity<VaccinationProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get VaccinationProcess by processInstanceId : {}", processInstanceId);
        Optional<VaccinationProcessDTO> vaccinationProcessDTO = vaccinationProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(vaccinationProcessDTO);
    }
}
