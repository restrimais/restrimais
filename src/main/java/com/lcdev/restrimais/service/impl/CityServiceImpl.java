package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.City;
import com.lcdev.restrimais.domain.entities.State;
import com.lcdev.restrimais.repository.CityRepository;
import com.lcdev.restrimais.repository.StateRepository;
import com.lcdev.restrimais.rest.dto.city.CityStateDTO;
import com.lcdev.restrimais.service.CityService;
import com.lcdev.restrimais.service.exceptions.CityAlreadyExistsException;
import com.lcdev.restrimais.service.exceptions.DatabaseException;
import com.lcdev.restrimais.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;
    private final StateRepository stateRepository;

    @Transactional
    public CityStateDTO save(CityStateDTO dto) {
        State state = findOrCreateState(dto.getState().getName());
        validateCityNotExists(dto.getName(), state);

        City entity = createCity(dto.getName(), state);
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
    public CityStateDTO update(Long id, CityStateDTO dto) {
        City entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        State state = findOrCreateState(dto.getState().getName());

        validateCityNotExists(dto.getName(), state);
        updateCityEntity(entity, dto.getName(), state);

        entity = repository.save(entity);
        return new CityStateDTO(entity);
    }

    private void updateCityEntity(City entity, String cityName, State state) {
        entity.setName(cityName);
        entity.setState(state);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial!");
        }
    }

    public State findOrCreateState(String stateName) {
        State state = stateRepository.findByName(stateName);
        if (state == null) {
            state = new State();
            state.setName(stateName);
            state = stateRepository.save(state);
        }
        return state;
    }

    private void validateCityNotExists(String cityName, State state) {
        City existingCity = repository.findByNameAndState(cityName, state);
        if (existingCity != null) {
            throw new CityAlreadyExistsException("A cidade com o mesmo nome já existe no mesmo estado.");
        }
    }

    public City createCity(String cityName, State state) {
        City city = new City();
        city.setName(cityName);
        city.setState(state);
        return city;
    }

}
