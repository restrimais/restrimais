package com.lcdev.restrimais.service;

import com.lcdev.restrimais.lib.dto.patient.PatientAddressDTO;
import com.lcdev.restrimais.lib.dto.patient.PatientDTO;

import java.util.List;

public interface PatientService {

    PatientAddressDTO save(PatientAddressDTO dto);

    PatientDTO update(Long id, PatientDTO dto);

    PatientAddressDTO findById(Long id);

    List<PatientDTO> findAll();

    void delete(Long id);
}
