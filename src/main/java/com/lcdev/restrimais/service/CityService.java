package com.lcdev.restrimais.service;

import com.lcdev.restrimais.lib.entities.City;
import com.lcdev.restrimais.lib.entities.State;
import com.lcdev.restrimais.lib.dto.city.CityStateDTO;

import java.util.List;

public interface CityService {

    CityStateDTO save(CityStateDTO dto);
    CityStateDTO findById(Long id);
    List<CityStateDTO> findAll();
    CityStateDTO update(Long id, CityStateDTO dto);
    void delete(Long id);

    City createCity(String cityName, State state);

    City findByNameAndState(String name, State state);
}
