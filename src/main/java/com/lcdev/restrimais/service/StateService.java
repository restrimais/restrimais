package com.lcdev.restrimais.service;

import com.lcdev.restrimais.rest.dto.state.StateCityDTO;
import com.lcdev.restrimais.rest.dto.state.StateDTO;

import java.util.List;

public interface StateService {

    StateDTO findById(Long id);
    List<StateCityDTO> findAll();
    StateDTO save(StateDTO dto);
    StateDTO update(Long id, StateDTO dto);
    void delete(Long id);
}
