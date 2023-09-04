package com.lcdev.restrimais.service;

import com.lcdev.restrimais.domain.entities.State;
import com.lcdev.restrimais.repository.StateRepository;
import com.lcdev.restrimais.rest.dto.StateDTO;
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
public class StateService {

    @Autowired
    private StateRepository repository;

    @Transactional(readOnly = true)
    public StateDTO findById(Long id){
        State state = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new StateDTO(state);
    }

    @Transactional(readOnly = true)
    public List<StateDTO> findAll(){
        List<State> result = repository.findAll();
        return result.stream().map(StateDTO::new).collect(Collectors.toList());
    }

    @Transactional()
    public StateDTO save(StateDTO dto){
        State entity = new State();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new StateDTO(entity);
    }

    @Transactional()
    public StateDTO update(Long id, StateDTO dto){
        try {
            State entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new StateDTO(entity);
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
