package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.CategoryInDTOToTask;
import com.laguna.supermaket.persistence.entity.Category;
import com.laguna.supermaket.persistence.repository.CategoryRepository;
import com.laguna.supermaket.service.dto.CategoryInDTO;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    private final CategoryInDTOToTask mapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryInDTOToTask mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public Category createCategory(CategoryInDTO categoryInDTO) {
        Category category = mapper.map(categoryInDTO);
        return this.categoryRepository.save(category);
    }
}
