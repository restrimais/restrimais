package com.lcdev.restrimais.service;

import com.lcdev.restrimais.domain.entities.City;
import com.lcdev.restrimais.domain.entities.State;
import com.lcdev.restrimais.repository.CityRepository;
import com.lcdev.restrimais.rest.dto.city.CityStateDTO;
import com.lcdev.restrimais.service.exceptions.DatabaseException;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    @Transactional
    public CityStateDTO save(CityStateDTO dto){
        City entity = new City();
        entity.setName(dto.getName());

        State state = new State();
        state.setId(dto.getState().getId());
        state.setName(dto.getState().getName());

        entity.setState(state);
        entity = repository.save(entity);
        return new CityStateDTO(entity);
    }

    @Transactional(readOnly = true)
    public CityStateDTO findById(Long id){
        City city = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new CityStateDTO(city);
    }

    @Transactional(readOnly = true)
    public List<CityStateDTO> findAll(){
        List<City> result = repository.findAll();
        return result.stream().map(CityStateDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public CityStateDTO update(Long id, CityStateDTO dto){
        try {
            City entity = repository.getReferenceById(id);
            entity.setName(dto.getName());

            State state = new State();
            state.setId(dto.getState().getId());
            state.setName(dto.getState().getName());

            entity.setState(state);
            entity = repository.save(entity);
            return new CityStateDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial!");
        }
    }
}
