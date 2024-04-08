package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.domain.entities.Category;
import com.lcdev.restrimais.domain.entities.Ingredient;
import com.lcdev.restrimais.domain.entities.Preparation;
import com.lcdev.restrimais.domain.entities.Revenue;
import com.lcdev.restrimais.mapper.RevenueMapper;
import com.lcdev.restrimais.rest.dto.category.CategoryDTO;
import com.lcdev.restrimais.rest.dto.ingredients.IngredientsDTO;
import com.lcdev.restrimais.rest.dto.revenue.RevenueDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RevenueMapperImpl implements RevenueMapper {
    @Override
    public Revenue mapRevenue(RevenueDTO dto) {
        Revenue entity = new Revenue();

        entity.setTitle(dto.getTitle());
        entity.setImg(dto.getImg());
        entity.setDescription(dto.getDescription());

        entity.getCategories().clear();
        for (CategoryDTO categoryDTO : dto.getCategories()){
            Category cat = new Category();
            cat.setId(categoryDTO.getId());
            entity.getCategories().add(cat);
        }

        for (IngredientsDTO ingredientDTO : dto.getIngredients()){
            Ingredient ingredient = new Ingredient();
            ingredient.setIgredient(ingredientDTO.getIgredient());
            ingredient.setRevenue(entity);
            entity.getIngredients().add(ingredient);
        }

        Preparation preparation = new Preparation();

        preparation.setRevenue(entity);
        preparation.setTime(dto.getPreparetion().getTime());
        preparation.setStep(dto.getPreparetion().getStep());
        preparation.setTemperature(dto.getPreparetion().getTemperature());
        preparation.setObservation(dto.getPreparetion().getObservation());

        entity.setPreparation(preparation);



        return entity;
    }
}
