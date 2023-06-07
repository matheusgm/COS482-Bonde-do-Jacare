package org.agilekip.bondedojacare.repository;

import org.agilekip.bondedojacare.domain.Vaccination;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Vaccination entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {}
