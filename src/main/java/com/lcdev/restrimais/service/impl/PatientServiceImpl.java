package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.Address;
import com.lcdev.restrimais.domain.entities.City;
import com.lcdev.restrimais.domain.entities.Patient;
import com.lcdev.restrimais.domain.entities.State;
import com.lcdev.restrimais.repository.PatientRepository;
import com.lcdev.restrimais.rest.dto.address.AddressDTO;
import com.lcdev.restrimais.rest.dto.patient.PatientDTO;
import com.lcdev.restrimais.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    @Transactional()
    public PatientDTO save(PatientDTO dto) {
        Patient entity = new Patient();
        copyDtoToEntity(dto, entity);

        entity = repository.save(entity);
        return new PatientDTO(entity);
    }

    public void copyDtoToEntity(PatientDTO dto, Patient entity) {
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

        for (AddressDTO addressDTO : dto.getAddress()) {
            Address address = new Address();
            address.setStreet(addressDTO.getStreet());
            address.setNumber(addressDTO.getNumber());
            address.setComplement(addressDTO.getComplement());
            address.setNeighborhood(addressDTO.getNeighborhood());
            address.setCep(addressDTO.getCep());

            City city = new City();
            city.setName(addressDTO.getCity().getName());

            State state = new State();
            state.setName(addressDTO.getCity().getState().getName());

            city.setState(state);
            address.setCity(city);

            entity.getAddresses().add(address);
        }
    }
}
