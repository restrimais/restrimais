package com.lcdev.restrimais.service;

import com.lcdev.restrimais.rest.dto.patient.PatientAddressDTO;
import com.lcdev.restrimais.rest.dto.patient.PatientDTO;

import java.util.List;
import java.util.Set;

public interface PatientService {

    PatientAddressDTO save(PatientAddressDTO dto);

    PatientDTO update(Long id, PatientDTO dto);

    PatientAddressDTO findById(Long id);

    List<PatientDTO> findAll();

    void delete(Long id);
}
