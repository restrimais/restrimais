package com.lcdev.restrimais.rest.dto.revenue;

import com.lcdev.restrimais.domain.entities.Revenue;
import com.lcdev.restrimais.rest.dto.ingredients.IngredientsDTO;
import com.lcdev.restrimais.rest.dto.preparetion.PreparetionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueDTO {

    private Long id;
    private String title;
    private String img;
    private String description;
    private PreparetionDTO preparetion;
    private List<IngredientsDTO> ingredients = new ArrayList<>();

    public RevenueDTO(Revenue entity){
        id = entity.getId();
        title = entity.getTitle();
        img = entity.getImg();
        description = entity.getDescription();
        preparetion = new PreparetionDTO(entity.getPreparation());
        ingredients = entity.getIngredients().stream().map(IngredientsDTO::new).collect(Collectors.toList());
    }

}
