package com.lcdev.restrimais.service;

import com.lcdev.restrimais.domain.entities.City;
import com.lcdev.restrimais.domain.entities.State;
import com.lcdev.restrimais.rest.dto.city.CityStateDTO;

import java.util.List;

public interface CityService {

    CityStateDTO save(CityStateDTO dto);
    CityStateDTO findById(Long id);
    List<CityStateDTO> findAll();
    CityStateDTO update(Long id, CityStateDTO dto);
    void delete(Long id);

    State findOrCreateState(String stateName);

    City createCity(String cityName, State state);
}
