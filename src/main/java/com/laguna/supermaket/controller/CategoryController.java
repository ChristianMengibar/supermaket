package com.laguna.supermaket.controller;

import com.laguna.supermaket.persistence.entity.Category;
import com.laguna.supermaket.service.CategoryService;
import com.laguna.supermaket.service.dto.CategoryInDTO;
import com.laguna.supermaket.service.dto.ProductInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCategory(@RequestBody CategoryInDTO categoryInDTO) {
        try {
            this.categoryService.deleteCategory(categoryInDTO);
            return ResponseEntity.ok("Categoria borrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("ERROR al borrar la categoria: " + e.getMessage());
        }
    }
}
