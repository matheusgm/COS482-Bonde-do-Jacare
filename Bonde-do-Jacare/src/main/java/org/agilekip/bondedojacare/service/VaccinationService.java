package org.agilekip.bondedojacare.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.agilekip.bondedojacare.domain.Vaccination;
import org.agilekip.bondedojacare.repository.VaccinationRepository;
import org.agilekip.bondedojacare.service.dto.VaccinationDTO;
import org.agilekip.bondedojacare.service.mapper.VaccinationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Vaccination}.
 */
@Service
@Transactional
public class VaccinationService {

    private final Logger log = LoggerFactory.getLogger(VaccinationService.class);

    private final VaccinationRepository vaccinationRepository;

    private final VaccinationMapper vaccinationMapper;

    public VaccinationService(VaccinationRepository vaccinationRepository, VaccinationMapper vaccinationMapper) {
        this.vaccinationRepository = vaccinationRepository;
        this.vaccinationMapper = vaccinationMapper;
    }

    /**
     * Save a vaccination.
     *
     * @param vaccinationDTO the entity to save.
     * @return the persisted entity.
     */
    public VaccinationDTO save(VaccinationDTO vaccinationDTO) {
        log.debug("Request to save Vaccination : {}", vaccinationDTO);
        Vaccination vaccination = vaccinationMapper.toEntity(vaccinationDTO);
        vaccination = vaccinationRepository.save(vaccination);
        return vaccinationMapper.toDto(vaccination);
    }

    /**
     * Partially update a vaccination.
     *
     * @param vaccinationDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<VaccinationDTO> partialUpdate(VaccinationDTO vaccinationDTO) {
        log.debug("Request to partially update Vaccination : {}", vaccinationDTO);

        return vaccinationRepository
            .findById(vaccinationDTO.getId())
            .map(
                existingVaccination -> {
                    vaccinationMapper.partialUpdate(existingVaccination, vaccinationDTO);
                    return existingVaccination;
                }
            )
            .map(vaccinationRepository::save)
            .map(vaccinationMapper::toDto);
    }

    /**
     * Get all the vaccinations.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<VaccinationDTO> findAll() {
        log.debug("Request to get all Vaccinations");
        return vaccinationRepository.findAll().stream().map(vaccinationMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one vaccination by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<VaccinationDTO> findOne(Long id) {
        log.debug("Request to get Vaccination : {}", id);
        return vaccinationRepository.findById(id).map(vaccinationMapper::toDto);
    }

    /**
     * Delete the vaccination by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Vaccination : {}", id);
        vaccinationRepository.deleteById(id);
    }
}
