package org.agilekip.bondedojacare.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link org.agilekip.bondedojacare.domain.Vaccination} entity.
 */
public class VaccinationDTO implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    private String job;

    private String phoneNumber;

    private String address;

    private LocalDate dateAndTime;

    private String vaccineType;

    private String applicator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDate dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public String getApplicator() {
        return applicator;
    }

    public void setApplicator(String applicator) {
        this.applicator = applicator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VaccinationDTO)) {
            return false;
        }

        VaccinationDTO vaccinationDTO = (VaccinationDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, vaccinationDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VaccinationDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", age=" + getAge() +
            ", job='" + getJob() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", address='" + getAddress() + "'" +
            ", dateAndTime='" + getDateAndTime() + "'" +
            ", vaccineType='" + getVaccineType() + "'" +
            ", applicator='" + getApplicator() + "'" +
            "}";
    }
}
