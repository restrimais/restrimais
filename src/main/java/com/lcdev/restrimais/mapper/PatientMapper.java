package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.domain.entities.Patient;
import com.lcdev.restrimais.rest.dto.patient.PatientAddressDTO;
import com.lcdev.restrimais.rest.dto.patient.PatientDTO;

public interface PatientMapper {

    Patient mapPatientAdress(PatientAddressDTO dto);

    Patient mapPatient(PatientDTO dto, Patient entity);
}
