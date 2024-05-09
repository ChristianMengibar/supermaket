package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.CategoryInDtoMapper;
import com.laguna.supermaket.persistence.entity.Category;
import com.laguna.supermaket.persistence.repository.CategoryRepository;
import com.laguna.supermaket.service.dto.CategoryOutDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    private final CategoryInDtoMapper mapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryInDtoMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    //De Category a DTO de salida.
    private CategoryOutDto mapToOutDto(Category category) {
        return mapper.categoryToCategoryOutDto(category);
    }

    public CategoryOutDto getCategoryById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.map(this::mapToOutDto).orElse(null);
    }

    public List<CategoryOutDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(this::mapToOutDto).collect(Collectors.toList());
    }

}
