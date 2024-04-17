package com.laguna.supermaket.controller;

import com.laguna.supermaket.persistence.entity.Category;
import com.laguna.supermaket.service.CategoryService;
import com.laguna.supermaket.service.dto.CategoryInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public List<Category> findAll(){
        return this.categoryService.findAll();
    }
}
