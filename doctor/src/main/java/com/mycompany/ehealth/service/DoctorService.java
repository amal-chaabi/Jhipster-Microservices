package com.mycompany.ehealth.service;

import com.mycompany.ehealth.service.dto.DoctorDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.ehealth.domain.Doctor}.
 */
public interface DoctorService {

    /**
     * Save a doctor.
     *
     * @param doctorDTO the entity to save.
     * @return the persisted entity.
     */
    DoctorDTO save(DoctorDTO doctorDTO);

    /**
     * Get all the doctors.
     *
     * @return the list of entities.
     */
    List<DoctorDTO> findAll();


    /**
     * Get the "id" doctor.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DoctorDTO> findOne(Long id);

    /**
     * Delete the "id" doctor.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
