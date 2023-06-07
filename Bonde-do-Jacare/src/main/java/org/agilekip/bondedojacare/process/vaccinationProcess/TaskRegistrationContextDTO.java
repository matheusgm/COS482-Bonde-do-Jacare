package org.agilekip.bondedojacare.process.vaccinationProcess;

import org.agilekip.bondedojacare.service.dto.VaccinationProcessDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class TaskRegistrationContextDTO {

    private VaccinationProcessDTO vaccinationProcess;
    private TaskInstanceDTO taskInstance;

    public VaccinationProcessDTO getVaccinationProcess() {
        return vaccinationProcess;
    }

    public void setVaccinationProcess(VaccinationProcessDTO vaccinationProcess) {
        this.vaccinationProcess = vaccinationProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
