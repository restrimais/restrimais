package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.lib.entities.Category;
import com.lcdev.restrimais.mapper.CategoryMapper;
import com.lcdev.restrimais.lib.dto.category.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category mapCategory(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        return entity;
    }
}
