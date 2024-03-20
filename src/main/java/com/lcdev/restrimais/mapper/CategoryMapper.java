package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.domain.entities.Category;
import com.lcdev.restrimais.rest.dto.category.CategoryDTO;

public interface CategoryMapper {

    Category mapCategory(CategoryDTO dto);
}
