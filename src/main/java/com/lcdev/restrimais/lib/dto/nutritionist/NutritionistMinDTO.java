package com.lcdev.restrimais.lib.dto.nutritionist;

import com.lcdev.restrimais.lib.entities.Nutritionist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutritionistMinDTO {

    private Long id;
    private String name;
    private String profileImg;
    private String specialization;
    private String biography;

    public NutritionistMinDTO(Nutritionist entity){
        id = entity.getId();
        name = entity.getName();
        specialization = entity.getSpecialization();
        biography = entity.getBiography();
    }

}
