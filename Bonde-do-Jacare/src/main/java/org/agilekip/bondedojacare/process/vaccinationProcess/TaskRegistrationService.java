package org.agilekip.bondedojacare.process.vaccinationProcess;

import org.agilekip.bondedojacare.repository.VaccinationProcessRepository;
import org.agilekip.bondedojacare.service.VaccinationService;
import org.agilekip.bondedojacare.service.dto.VaccinationDTO;
import org.agilekip.bondedojacare.service.dto.VaccinationProcessDTO;
import org.agilekip.bondedojacare.service.mapper.VaccinationProcessMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskRegistrationService {

    private final TaskInstanceService taskInstanceService;

    private final VaccinationService vaccinationService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final VaccinationProcessRepository vaccinationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskRegistrationMapper taskRegistrationMapper;

    private final VaccinationProcessMapper vaccinationProcessMapper;

    public TaskRegistrationService(
        TaskInstanceService taskInstanceService,
        VaccinationService vaccinationService,
        TaskInstanceRepository taskInstanceRepository,
        VaccinationProcessRepository vaccinationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskRegistrationMapper taskRegistrationMapper,
        VaccinationProcessMapper vaccinationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.vaccinationService = vaccinationService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.vaccinationProcessRepository = vaccinationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskRegistrationMapper = taskRegistrationMapper;
        this.vaccinationProcessMapper = vaccinationProcessMapper;
    }

    public TaskRegistrationContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        VaccinationProcessDTO vaccinationProcess = vaccinationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskRegistrationMapper::toVaccinationProcessDTO)
            .orElseThrow();

        TaskRegistrationContextDTO taskRegistrationContext = new TaskRegistrationContextDTO();
        taskRegistrationContext.setTaskInstance(taskInstanceDTO);
        taskRegistrationContext.setVaccinationProcess(vaccinationProcess);

        return taskRegistrationContext;
    }

    public TaskRegistrationContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskRegistrationContextDTO taskRegistrationContext) {
        VaccinationDTO vaccinationDTO = vaccinationService
            .findOne(taskRegistrationContext.getVaccinationProcess().getVaccination().getId())
            .orElseThrow();
        vaccinationDTO.setName(taskRegistrationContext.getVaccinationProcess().getVaccination().getName());
        vaccinationDTO.setBirthDate(taskRegistrationContext.getVaccinationProcess().getVaccination().getBirthDate());
        vaccinationDTO.setJob(taskRegistrationContext.getVaccinationProcess().getVaccination().getJob());
        vaccinationDTO.setPhoneNumber(taskRegistrationContext.getVaccinationProcess().getVaccination().getPhoneNumber());
        vaccinationDTO.setAddress(taskRegistrationContext.getVaccinationProcess().getVaccination().getAddress());
        vaccinationService.save(vaccinationDTO);
    }

    public void complete(TaskRegistrationContextDTO taskRegistrationContext) {
        save(taskRegistrationContext);
        VaccinationProcessDTO vaccinationProcess = vaccinationProcessRepository
            .findByProcessInstanceId(taskRegistrationContext.getVaccinationProcess().getProcessInstance().getId())
            .map(vaccinationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskRegistrationContext.getTaskInstance(), vaccinationProcess);
    }
}
