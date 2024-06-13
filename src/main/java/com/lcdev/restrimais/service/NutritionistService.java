package com.lcdev.restrimais.service;

import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistAddressDTO;
import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistDTO;
import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistMinDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NutritionistService {

    NutritionistAddressDTO save(NutritionistAddressDTO dto);

    NutritionistDTO update(Long id, NutritionistDTO dto);

    NutritionistAddressDTO findById(Long id);

    Page<NutritionistMinDTO> findAll(String name, Pageable pageable);

    void delete(Long id);
}
