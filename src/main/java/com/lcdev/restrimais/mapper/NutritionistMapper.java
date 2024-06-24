package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.lib.entities.Nutritionist;
import com.lcdev.restrimais.lib.dto.nutritionist.NutritionistAddressDTO;
import com.lcdev.restrimais.lib.dto.nutritionist.NutritionistDTO;

public interface NutritionistMapper {

    Nutritionist mapNutritionistAdress(NutritionistAddressDTO dto);

    Nutritionist mapNutritionist(NutritionistDTO dto, Nutritionist entity);
}
