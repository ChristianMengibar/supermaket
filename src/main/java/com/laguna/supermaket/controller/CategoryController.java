package com.laguna.supermaket.controller;

import com.laguna.supermaket.service.CategoryService;
import com.laguna.supermaket.service.dto.CategoryOutDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public CategoryOutDto getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/all")
    public List<CategoryOutDto> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
