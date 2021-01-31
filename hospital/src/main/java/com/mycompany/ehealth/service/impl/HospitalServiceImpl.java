package com.mycompany.ehealth.service.impl;

import com.mycompany.ehealth.service.HospitalService;
import com.mycompany.ehealth.client.AuthorizedFeignClient;
import com.mycompany.ehealth.client.AuthorizedUserFeignClient;
import com.mycompany.ehealth.client.remoteEntities.*;
import com.mycompany.ehealth.client.DoctorServiceClient;
import com.mycompany.ehealth.domain.Hospital;
import com.mycompany.ehealth.repository.HospitalRepository;
import com.mycompany.ehealth.service.dto.HospitalDTO;
import com.mycompany.ehealth.service.mapper.HospitalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.*;


/**
 * Service Implementation for managing {@link Hospital}.
 */
@Service
@Transactional

public class HospitalServiceImpl implements HospitalService {
	
	
	private static Logger log =  LoggerFactory.getLogger(HospitalServiceImpl.class);
	

    private final HospitalRepository hospitalRepository;

    private final HospitalMapper hospitalMapper;

    @Autowired
    DoctorServiceClient doctorServiceClient;
    

    
    public HospitalServiceImpl(HospitalRepository hospitalRepository, HospitalMapper hospitalMapper) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalMapper = hospitalMapper;
    }

    @Override
    public HospitalDTO save(HospitalDTO hospitalDTO) {
         log.debug("Request to save Hospital : {}", hospitalDTO);
        Hospital hospital = hospitalMapper.toEntity(hospitalDTO);
        hospital = hospitalRepository.save(hospital);
        return hospitalMapper.toDto(hospital);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HospitalDTO> findAll() {
        log.debug("Request to get all Hospitals");
        log.info("\n \n \n \n \n "+doctorServiceClient.getAllDoctors().toString()+"\n \n \n \n \n ");

        List<Doctor> dlist = doctorServiceClient.getAllDoctors();
        return hospitalRepository.findAll().stream()
            .map(hospitalMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<HospitalDTO> findOne(Long id) {
        log.debug("Request to get Hospital : {}", id);
        return hospitalRepository.findById(id)
            .map(hospitalMapper::toDto);
    }

    @Override
    public void delete(Long id) {
      log.debug("Request to delete Hospital : {}", id);
        hospitalRepository.deleteById(id);
    }
}
