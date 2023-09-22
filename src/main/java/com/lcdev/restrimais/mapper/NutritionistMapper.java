package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistAddressDTO;
import com.lcdev.restrimais.rest.dto.nutritionist.NutritionistDTO;

public interface NutritionistMapper {

    Nutritionist mapNutritionistAdress(NutritionistAddressDTO dto);

    Nutritionist mapNutritionist(NutritionistDTO dto, Nutritionist entity);
}
