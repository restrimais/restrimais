package com.lcdev.restrimais.service;

import com.lcdev.restrimais.lib.dto.category.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> findAll();
    CategoryDTO save(CategoryDTO dto);

}
