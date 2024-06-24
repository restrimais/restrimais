package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.lib.entities.Patient;
import com.lcdev.restrimais.mapper.PatientMapper;
import com.lcdev.restrimais.mapper.RestrictionMapper;
import com.lcdev.restrimais.repository.PatientRepository;
import com.lcdev.restrimais.lib.dto.address.AddressDTO;
import com.lcdev.restrimais.lib.dto.patient.PatientAddressDTO;
import com.lcdev.restrimais.lib.dto.patient.PatientDTO;
import com.lcdev.restrimais.lib.dto.restriction.RestrictionMinDTO;
import com.lcdev.restrimais.service.AddressService;
import com.lcdev.restrimais.service.PatientService;
import com.lcdev.restrimais.service.RestrictionService;
import com.lcdev.restrimais.service.exceptions.DatabaseException;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    private final PatientMapper patientMapper;

    private final AddressService addressService;

    private final RestrictionService restrictionService;

    private final RestrictionMapper restrictionMapper;

    @Transactional
    public PatientAddressDTO save(PatientAddressDTO dto) {
        try {
            Patient entity = patientMapper.mapPatientAdress(dto);

            for (AddressDTO addressDTO : dto.getAddress()) {
                entity.getAddresses().add(addressService.persistAddress(addressDTO, entity, null));
            }

            for (RestrictionMinDTO restrictionMinDTO: dto.getRestrictions()){
                entity.getRestrictions().add(restrictionService.persistRestriction(restrictionMinDTO, entity));
            }

            entity = repository.save(entity);
            return new PatientAddressDTO(entity);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Email já cadastrado: " + dto.getEmail());
        }
    }

    @Override
    @Transactional
    public PatientDTO update(Long id, PatientDTO dto){
        Patient entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado."));
        patientMapper.mapPatient(dto, entity);
        entity = repository.save(entity);
        return new PatientDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public PatientAddressDTO findById(Long id){
        Patient entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado."));

        return new PatientAddressDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatientDTO> findAll() {
        List<Patient> result = repository.findAll();
        return result.stream().map(PatientDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial!");
        }
    }

}
