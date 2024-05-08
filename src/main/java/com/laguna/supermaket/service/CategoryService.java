package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.CategoryInDtoMapper;
import com.laguna.supermaket.persistence.entity.Category;
import com.laguna.supermaket.persistence.repository.CategoryRepository;
import com.laguna.supermaket.service.dto.CategoryInDto;
import com.laguna.supermaket.service.dto.CategoryOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    private final CategoryInDtoMapper mapper;

    public CategoryOutDto findByCategoryId(Long id) {

        return mapper.categoryToCategoryOutDto(categoryRepository.findById(id));
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category createCategory(CategoryInDto categoryInDTO) {
        Category category = mapper.categoryInDtoToCategory(categoryInDTO);
        return this.categoryRepository.save(category);
    }

    public void updateCategory(Long id, CategoryInDto categoryInDTO) {
        Category category = mapper.categoryInDtoToCategory(categoryInDTO);
        this.categoryRepository.save(category);
    }

    public void deleteCategory(CategoryInDto categoryInDTO) {
        Category category = mapper.categoryInDtoToCategory(categoryInDTO);
        this.categoryRepository.delete(category);
    }
}
