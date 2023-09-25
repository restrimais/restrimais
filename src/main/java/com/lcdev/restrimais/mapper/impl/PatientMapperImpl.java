package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.domain.entities.Patient;
import com.lcdev.restrimais.mapper.AddressMapper;
import com.lcdev.restrimais.mapper.PatientMapper;
import com.lcdev.restrimais.rest.dto.patient.PatientAddressDTO;
import com.lcdev.restrimais.rest.dto.patient.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientMapperImpl implements PatientMapper {

    private final AddressMapper addressMapper;

    @Override
    public Patient mapPatientAdress(PatientAddressDTO dto) {
        Patient entity = new Patient();

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setBirthDate(dto.getBirthDate());
        entity.setPassword(dto.getPassword());
        entity.setCpf(dto.getCpf());
        entity.setGender(dto.getGender());
        entity.setProfileImg(dto.getProfileImg());
        entity.setPhone(dto.getPhone());
        entity.setHeight(dto.getHeight());
        entity.setWeight(dto.getWeight());

        return entity;
    }

    @Override
    public Patient mapPatient(PatientDTO dto, Patient entity) {

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setBirthDate(dto.getBirthDate());
        entity.setPassword(dto.getPassword());
        entity.setCpf(dto.getCpf());
        entity.setGender(dto.getGender());
        entity.setProfileImg(dto.getProfileImg());
        entity.setPhone(dto.getPhone());
        entity.setHeight(dto.getHeight());
        entity.setWeight(dto.getWeight());

        return entity;
    }
}
