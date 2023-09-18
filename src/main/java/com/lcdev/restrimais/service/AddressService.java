package com.lcdev.restrimais.service;

import com.lcdev.restrimais.domain.entities.Address;
import com.lcdev.restrimais.rest.dto.address.AddressDTO;

public interface AddressService {

    AddressDTO save(AddressDTO dto);
    AddressDTO update(Long id, AddressDTO dto);
    AddressDTO findById(Long id);
    void delete(Long id);

    void copyDtoToEntity(AddressDTO dto , Address entity);
}
