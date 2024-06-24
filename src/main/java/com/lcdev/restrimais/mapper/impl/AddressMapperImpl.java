package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.lib.entities.Address;
import com.lcdev.restrimais.mapper.AddressMapper;
import com.lcdev.restrimais.lib.dto.address.AddressDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address mapAddress(AddressDTO dto) {
        Address entity = new Address();
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        entity.setComplement(dto.getComplement());
        entity.setNeighborhood(dto.getNeighborhood());
        entity.setCep(dto.getCep());

        return entity;
    }

}
