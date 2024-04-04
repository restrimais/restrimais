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
public class RevenueMinDTO {

    private Long id;
    private String title;
    private String img;
    private String description;

    public RevenueMinDTO(Revenue entity){
        id = entity.getId();
        title = entity.getTitle();
        img = entity.getImg();
        description = entity.getDescription();
    }

}
