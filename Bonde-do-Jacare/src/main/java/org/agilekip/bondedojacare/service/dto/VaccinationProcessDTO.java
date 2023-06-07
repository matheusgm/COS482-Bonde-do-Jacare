package org.agilekip.bondedojacare.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link org.agilekip.bondedojacare.domain.VaccinationProcess} entity.
 */
public class VaccinationProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private VaccinationDTO vaccination;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public VaccinationDTO getVaccination() {
        return vaccination;
    }

    public void setVaccination(VaccinationDTO vaccination) {
        this.vaccination = vaccination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VaccinationProcessDTO)) {
            return false;
        }

        VaccinationProcessDTO vaccinationProcessDTO = (VaccinationProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, vaccinationProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VaccinationProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", vaccination=" + getVaccination() +
            "}";
    }
}
