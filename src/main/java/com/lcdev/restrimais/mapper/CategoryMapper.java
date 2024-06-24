package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.lib.entities.Category;
import com.lcdev.restrimais.lib.dto.category.CategoryDTO;

public interface CategoryMapper {

    Category mapCategory(CategoryDTO dto);
}
