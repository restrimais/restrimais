package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.Category;
import com.lcdev.restrimais.mapper.CategoryMapper;
import com.lcdev.restrimais.repository.CategoryRepository;
import com.lcdev.restrimais.rest.dto.category.CategoryDTO;
import com.lcdev.restrimais.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository repository;

    private final CategoryMapper categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> result = repository.findAll();
        return result.stream().map(CategoryDTO::new).toList();
    }

    @Override
    @Transactional()
    public CategoryDTO save(CategoryDTO dto) {
        Category entity = repository.save(categoryMapper.mapCategory(dto));
        return new CategoryDTO(entity);
    }
}
