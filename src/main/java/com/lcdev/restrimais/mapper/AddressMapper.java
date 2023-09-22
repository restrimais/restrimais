package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.domain.entities.Address;
import com.lcdev.restrimais.rest.dto.address.AddressDTO;

public interface AddressMapper {

    Address mapAddress(AddressDTO dto);
}
