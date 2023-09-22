package com.lcdev.restrimais.service;

import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistAddressDTO;
import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistDTO;

import java.util.List;

public interface NutritionistService {

    NutritionistAddressDTO save(NutritionistAddressDTO dto);

    NutritionistDTO update(Long id, NutritionistDTO dto);

    NutritionistAddressDTO findById(Long id);

    List<NutritionistDTO> findAll();

    void delete(Long id);
}
