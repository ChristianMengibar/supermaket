package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.CategoryInDTOToTask;
import com.laguna.supermaket.persistence.entity.Category;
import com.laguna.supermaket.persistence.repository.CategoryRepository;
import com.laguna.supermaket.service.dto.CategoryInDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    private final CategoryInDTOToTask mapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryInDTOToTask mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public Optional<Category> findByCategoryId(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category createCategory(CategoryInDTO categoryInDTO) {
        Category category = mapper.map(categoryInDTO);
        return this.categoryRepository.save(category);
    }

    public void updateCategory(Long id, CategoryInDTO categoryInDTO) {
        Category category = mapper.map(categoryInDTO);
        this.categoryRepository.save(category);
    }

    public void deleteCategory(CategoryInDTO categoryInDTO) {
        Category category = mapper.map(categoryInDTO);
        this.categoryRepository.delete(category);
    }
}
