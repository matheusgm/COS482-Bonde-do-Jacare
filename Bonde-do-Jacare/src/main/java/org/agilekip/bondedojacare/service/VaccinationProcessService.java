package org.agilekip.bondedojacare.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.agilekip.bondedojacare.domain.VaccinationProcess;
import org.agilekip.bondedojacare.repository.VaccinationProcessRepository;
import org.agilekip.bondedojacare.repository.VaccinationRepository;
import org.agilekip.bondedojacare.service.dto.VaccinationProcessDTO;
import org.agilekip.bondedojacare.service.mapper.VaccinationProcessMapper;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link VaccinationProcess}.
 */
@Service
@Transactional
public class VaccinationProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "VaccinationProcess";

    private final Logger log = LoggerFactory.getLogger(VaccinationProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final VaccinationRepository vaccinationRepository;

    private final VaccinationProcessRepository vaccinationProcessRepository;

    private final VaccinationProcessMapper vaccinationProcessMapper;

    public VaccinationProcessService(
        ProcessInstanceService processInstanceService,
        VaccinationRepository vaccinationRepository,
        VaccinationProcessRepository vaccinationProcessRepository,
        VaccinationProcessMapper vaccinationProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.vaccinationRepository = vaccinationRepository;
        this.vaccinationProcessRepository = vaccinationProcessRepository;
        this.vaccinationProcessMapper = vaccinationProcessMapper;
    }

    /**
     * Save a vaccinationProcess.
     *
     * @param vaccinationProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public VaccinationProcessDTO create(VaccinationProcessDTO vaccinationProcessDTO) {
        log.debug("Request to save VaccinationProcess : {}", vaccinationProcessDTO);

        VaccinationProcess vaccinationProcess = vaccinationProcessMapper.toEntity(vaccinationProcessDTO);

        //Saving the domainEntity
        vaccinationRepository.save(vaccinationProcess.getVaccination());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "Vaccination#" + vaccinationProcess.getVaccination().getId(),
            vaccinationProcess
        );
        vaccinationProcess.setProcessInstance(processInstance);

        //Saving the process entity
        vaccinationProcess = vaccinationProcessRepository.save(vaccinationProcess);
        return vaccinationProcessMapper.toDto(vaccinationProcess);
    }

    /**
     * Get all the vaccinationProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<VaccinationProcessDTO> findAll() {
        log.debug("Request to get all VaccinationProcesss");
        return vaccinationProcessRepository
            .findAll()
            .stream()
            .map(vaccinationProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one vaccinationProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<VaccinationProcessDTO> findOne(Long id) {
        log.debug("Request to get VaccinationProcess : {}", id);
        return vaccinationProcessRepository.findById(id).map(vaccinationProcessMapper::toDto);
    }

    /**
     * Get one vaccinationProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<VaccinationProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get VaccinationProcess by  processInstanceId: {}", processInstanceId);
        return vaccinationProcessRepository.findByProcessInstanceId(processInstanceId).map(vaccinationProcessMapper::toDto);
    }
}
