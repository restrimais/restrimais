package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.lib.entities.Category;
import com.lcdev.restrimais.lib.entities.Restriction;
import com.lcdev.restrimais.mapper.RestrictionMapper;
import com.lcdev.restrimais.lib.dto.category.CategoryDTO;
import com.lcdev.restrimais.lib.dto.restriction.RestrictionMinDTO;
import org.springframework.stereotype.Component;

@Component
public class RestrictionMapperImpl implements RestrictionMapper {
    @Override
    public Restriction mapRestriction(RestrictionMinDTO dto) {
        Restriction entity = new Restriction();

        entity.setName(dto.getName());
        entity.getCategories().clear();
        for (CategoryDTO categoryDTO : dto.getCategories()){
            Category cat = new Category();
            cat.setId(categoryDTO.getId());
            entity.getCategories().add(cat);
        }
        return entity;
    }
}
