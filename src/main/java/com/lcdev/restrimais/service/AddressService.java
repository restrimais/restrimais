package com.lcdev.restrimais.service;

import com.lcdev.restrimais.domain.entities.Address;
import com.lcdev.restrimais.domain.entities.City;
import com.lcdev.restrimais.domain.entities.State;
import com.lcdev.restrimais.repository.AddressRepository;
import com.lcdev.restrimais.rest.dto.address.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Transactional
    public AddressDTO save(AddressDTO dto){
        Address entity = new Address();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new AddressDTO(entity);
    }

    public void copyDtoToEntity(AddressDTO dto ,Address entity){
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        entity.setComplement(dto.getComplement());
        entity.setNeighborhood(dto.getNeighborhood());
        entity.setCep(dto.getCep());

        City city = new City();
        city.setId(dto.getCity().getId());
        city.setName(dto.getCity().getName());
        entity.setCity(city);

        State state = new State();
        state.setId(dto.getCity().getState().getId());
        state.setName(dto.getCity().getState().getName());
        entity.getCity().setState(state);
    }
}
