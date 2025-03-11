package com.example.antiq.controllers;

import com.example.antiq.entity.Category;
import com.example.antiq.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
@Tag(name = "Category Management", description = "APIs for managing categories")
@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Get all categories", description = "Fetch a list of all categories")
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @Operation(summary = "Get a category by ID", description = "Fetch a specific category by its ID")
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @Operation(summary = "Create a new category", description = "Save a new category to the database")
    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.saveOrUpdateCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @Operation(summary = "Update a category", description = "Update an existing category by its ID")
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        Category foundCategory = categoryService.getCategoryById(id);
        category.setId(id);
        categoryService.saveOrUpdateCategory(category);
        return ResponseEntity.ok(category);
    }

    @Operation(summary = "Delete a category", description = "Remove a category from the database by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}

