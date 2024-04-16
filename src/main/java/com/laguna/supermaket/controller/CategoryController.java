package com.laguna.supermaket.controller;

import com.laguna.supermaket.persistence.entity.Category;
import com.laguna.supermaket.service.CategoryService;
import com.laguna.supermaket.service.dto.CategoryInDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryInDTO categoryInDTO) {
        return categoryService.createCategory(categoryInDTO);
    }
}
