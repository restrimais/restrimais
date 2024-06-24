package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.lib.entities.Address;
import com.lcdev.restrimais.lib.dto.address.AddressDTO;

public interface AddressMapper {

    Address mapAddress(AddressDTO dto);
}
