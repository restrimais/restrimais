package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.domain.entities.Address;
import com.lcdev.restrimais.domain.entities.City;
import com.lcdev.restrimais.domain.entities.State;
import com.lcdev.restrimais.mapper.AddressMapper;
import com.lcdev.restrimais.rest.dto.address.AddressDTO;
import com.lcdev.restrimais.service.CityService;
import com.lcdev.restrimais.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AddressMapperImpl implements AddressMapper {

    private final StateService stateService;

    private final CityService cityService;

    @Override
    public Address mapAddress(AddressDTO dto) {
        Address entity = new Address();
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        entity.setComplement(dto.getComplement());
        entity.setNeighborhood(dto.getNeighborhood());
        entity.setCep(dto.getCep());

        State state = stateService.findOrCreateState(dto.getCity().getState().getName());
        City city = cityService.findByNameAndState(dto.getCity().getName(), state);

        if (Objects.isNull(city)) city = cityService.createCity(dto.getCity().getName(), state);

        entity.setCity(city);

        return entity;
    }

}
