package org.agilekip.bondedojacare.repository;

import java.util.Optional;
import org.agilekip.bondedojacare.domain.VaccinationProcess;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the VaccinationProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VaccinationProcessRepository extends JpaRepository<VaccinationProcess, Long> {
    Optional<VaccinationProcess> findByProcessInstanceId(Long processInstanceId);
}
