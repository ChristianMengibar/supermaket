package com.laguna.supermaket.controller;

import com.laguna.supermaket.persistence.entity.Category;
import com.laguna.supermaket.service.CategoryService;
import com.laguna.supermaket.service.dto.CategoryInDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findByCategoryId(@PathVariable Long id) {
        Optional<Category> category = categoryService.findByCategoryId(id);

        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<Category> findAll() {
        return this.categoryService.findAll();
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryInDto categoryInDTO) {
        return categoryService.createCategory(categoryInDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id,
                                                 @RequestBody CategoryInDto categoryInDTO) {
        try {
            this.categoryService.updateCategory(id, categoryInDTO);
            return ResponseEntity.ok("Categoria borrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("ERROR al actualizar la categoria: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCategory(@RequestBody CategoryInDto categoryInDTO) {
        try {
            this.categoryService.deleteCategory(categoryInDTO);
            return ResponseEntity.ok("Categoria borrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("ERROR al borrar la categoria: " + e.getMessage());
        }
    }
}
