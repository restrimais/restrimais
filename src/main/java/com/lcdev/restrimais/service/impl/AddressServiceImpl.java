package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.Address;
import com.lcdev.restrimais.mapper.AddressMapper;
import com.lcdev.restrimais.repository.AddressRepository;
import com.lcdev.restrimais.rest.dto.address.AddressDTO;
import com.lcdev.restrimais.service.AddressService;
import com.lcdev.restrimais.service.exceptions.DatabaseException;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    private final AddressMapper addressMapper;


    @Transactional
    public AddressDTO save(AddressDTO dto){
        Address entity = addressMapper.mapAddress(dto);

        entity = repository.save(entity);
        return new AddressDTO(entity);
    }

    @Transactional(readOnly = true)
    public AddressDTO findById(Long id){
        Address address = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado!")
        );
        return new AddressDTO(address);
    }

    @Transactional
    public AddressDTO update(Long id, AddressDTO dto){
        try {
            Address entity = repository.getReferenceById(id);

            addressMapper.mapAddress(dto);
            entity = repository.save(entity);
            return new AddressDTO(entity);

        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial!");
        }
    }

}
