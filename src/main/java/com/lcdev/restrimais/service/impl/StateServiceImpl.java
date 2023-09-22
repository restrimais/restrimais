package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.State;
import com.lcdev.restrimais.repository.StateRepository;
import com.lcdev.restrimais.rest.dto.state.StateCityDTO;
import com.lcdev.restrimais.rest.dto.state.StateDTO;
import com.lcdev.restrimais.service.StateService;
import com.lcdev.restrimais.service.exceptions.DatabaseException;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

    private final StateRepository repository;

    @Override
    @Transactional(readOnly = true)
    public StateDTO findById(Long id){
        State state = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new StateDTO(state);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StateCityDTO> findAll(){
        List<State> result = repository.findAll();
        repository.findStatesCities(result);
        return result.stream().map(StateCityDTO::new).collect(Collectors.toList());
    }

    @Override
    public StateDTO save(StateDTO dto){
        State entity = new State();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new StateDTO(entity);
    }

    @Override
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

    @Override
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

    @Override
    public State findOrCreateState(String stateName) {
        State state = repository.findByName(stateName);
        if (state == null) {
            state = new State();
            state.setName(stateName);
            state = repository.save(state);
        }
        return state;
    }
}
