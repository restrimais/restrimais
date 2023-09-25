package com.lcdev.restrimais.service;

import com.lcdev.restrimais.domain.entities.Address;
import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.domain.entities.Patient;
import com.lcdev.restrimais.rest.dto.address.AddressDTO;

public interface AddressService {

    AddressDTO save(AddressDTO dto);
    AddressDTO update(Long id, AddressDTO dto);
    AddressDTO findById(Long id);
    void delete(Long id);

    Address persistAddress(AddressDTO addressDTO, Patient patient, Nutritionist nutritionist);

}
