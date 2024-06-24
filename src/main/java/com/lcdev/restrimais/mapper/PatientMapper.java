package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.lib.entities.Patient;
import com.lcdev.restrimais.lib.dto.patient.PatientAddressDTO;
import com.lcdev.restrimais.lib.dto.patient.PatientDTO;

public interface PatientMapper {

    Patient mapPatientAdress(PatientAddressDTO dto);

    Patient mapPatient(PatientDTO dto, Patient entity);
}
