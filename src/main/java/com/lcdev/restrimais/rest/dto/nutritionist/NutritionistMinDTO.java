package com.lcdev.restrimais.rest.dto.nutritionist;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
