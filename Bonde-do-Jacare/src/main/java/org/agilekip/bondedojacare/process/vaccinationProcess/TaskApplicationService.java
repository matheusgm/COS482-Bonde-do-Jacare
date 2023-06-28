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
public class TaskApplicationService {

    private final TaskInstanceService taskInstanceService;

    private final VaccinationService vaccinationService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final VaccinationProcessRepository vaccinationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskApplicationMapper taskApplicationMapper;

    private final VaccinationProcessMapper vaccinationProcessMapper;

    public TaskApplicationService(
        TaskInstanceService taskInstanceService,
        VaccinationService vaccinationService,
        TaskInstanceRepository taskInstanceRepository,
        VaccinationProcessRepository vaccinationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskApplicationMapper taskApplicationMapper,
        VaccinationProcessMapper vaccinationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.vaccinationService = vaccinationService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.vaccinationProcessRepository = vaccinationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskApplicationMapper = taskApplicationMapper;
        this.vaccinationProcessMapper = vaccinationProcessMapper;
    }

    public TaskApplicationContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        VaccinationProcessDTO vaccinationProcess = vaccinationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskApplicationMapper::toVaccinationProcessDTO)
            .orElseThrow();

        TaskApplicationContextDTO taskApplicationContext = new TaskApplicationContextDTO();
        taskApplicationContext.setTaskInstance(taskInstanceDTO);
        taskApplicationContext.setVaccinationProcess(vaccinationProcess);

        return taskApplicationContext;
    }

    public TaskApplicationContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskApplicationContextDTO taskApplicationContext) {
        VaccinationDTO vaccinationDTO = vaccinationService
            .findOne(taskApplicationContext.getVaccinationProcess().getVaccination().getId())
            .orElseThrow();
        vaccinationDTO.setName(taskApplicationContext.getVaccinationProcess().getVaccination().getName());
        vaccinationDTO.setAge(taskApplicationContext.getVaccinationProcess().getVaccination().getAge());
        vaccinationDTO.setJob(taskApplicationContext.getVaccinationProcess().getVaccination().getJob());
        vaccinationDTO.setPhoneNumber(taskApplicationContext.getVaccinationProcess().getVaccination().getPhoneNumber());
        vaccinationDTO.setAddress(taskApplicationContext.getVaccinationProcess().getVaccination().getAddress());
        vaccinationDTO.setDateAndTime(taskApplicationContext.getVaccinationProcess().getVaccination().getDateAndTime());
        vaccinationDTO.setVaccineType(taskApplicationContext.getVaccinationProcess().getVaccination().getVaccineType());
        vaccinationDTO.setApplicator(taskApplicationContext.getVaccinationProcess().getVaccination().getApplicator());
        vaccinationService.save(vaccinationDTO);
    }

    public void complete(TaskApplicationContextDTO taskApplicationContext) {
        save(taskApplicationContext);
        VaccinationProcessDTO vaccinationProcess = vaccinationProcessRepository
            .findByProcessInstanceId(taskApplicationContext.getVaccinationProcess().getProcessInstance().getId())
            .map(vaccinationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskApplicationContext.getTaskInstance(), vaccinationProcess);
    }
}
