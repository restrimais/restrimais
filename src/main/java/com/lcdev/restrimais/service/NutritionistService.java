package com.lcdev.restrimais.service;

import com.lcdev.restrimais.lib.dto.nutritionist.NutritionistAddressDTO;
import com.lcdev.restrimais.lib.dto.nutritionist.NutritionistAssessmentDTO;
import com.lcdev.restrimais.lib.dto.nutritionist.NutritionistDTO;
import com.lcdev.restrimais.lib.dto.nutritionist.NutritionistMinDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NutritionistService {

    NutritionistAddressDTO save(NutritionistAddressDTO dto);

    NutritionistDTO update(Long id, NutritionistDTO dto);

    NutritionistAssessmentDTO findById(Long id);

    Page<NutritionistMinDTO> findAll(String name, Pageable pageable);

    void delete(Long id);
}
