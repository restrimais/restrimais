package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.domain.entities.*;
import com.lcdev.restrimais.mapper.RevenueMapper;
import com.lcdev.restrimais.rest.dto.category.CategoryDTO;
import com.lcdev.restrimais.rest.dto.ingredients.IngredientsDTO;
import com.lcdev.restrimais.rest.dto.preparetion.PreparetionDTO;
import com.lcdev.restrimais.rest.dto.revenue.RevenueDTO;
import com.lcdev.restrimais.rest.dto.steps.StepDTO;
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
        entity.setCount(dto.getCount());
        entity.setScore(dto.getScore());

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
        preparation.setTemperature(dto.getPreparetion().getTemperature());
        preparation.setObservation(dto.getPreparetion().getObservation());

        for (StepDTO stepDTO : dto.getPreparetion().getSteps()){
            Step step = new Step();
            step.setStep(stepDTO.getStep());
            step.setPreparation(preparation);
            preparation.getSteps().add(step);
        }

        entity.setPreparation(preparation);

        return entity;
    }
}
