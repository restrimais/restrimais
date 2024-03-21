package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.domain.entities.Category;
import com.lcdev.restrimais.domain.entities.Restriction;
import com.lcdev.restrimais.mapper.RestrictionMapper;
import com.lcdev.restrimais.rest.dto.category.CategoryDTO;
import com.lcdev.restrimais.rest.dto.restriction.RestrictionDTO;
import org.springframework.stereotype.Component;

@Component
public class RestrictionMapperImpl implements RestrictionMapper {
    @Override
    public Restriction mapRestriction(RestrictionDTO dto) {
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
