package com.lcdev.restrimais.rest.dto.ingredients;

import com.lcdev.restrimais.domain.entities.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsDTO {

    private Long id;
    private String igredient;

    public IngredientsDTO (Ingredient entity){
        id = entity.getId();
        igredient = entity.getIgredient();
    }
}
