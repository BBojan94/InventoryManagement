package com.bojan.inventorymanagement.controller;

import com.bojan.inventorymanagement.dto.CategoryDTO;
import com.bojan.inventorymanagement.exception.ResourceNotFoundException;
import com.bojan.inventorymanagement.mapper.CategoryMapper;
import com.bojan.inventorymanagement.model.Category;
import com.bojan.inventorymanagement.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST Controller for handling category-related endpoints.
 * Provides CRUD operations for Category resources.
 */
@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    // Injected service for handling business logic
    private final CategoryService categoryService;

    /**
     * Endpoint to create a new category.
     *
     * @param categoryDTO the category data to be created
     * @return the created category as a DTO
     */
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        Category saved = categoryService.saveCategory(category);
        return ResponseEntity.ok(CategoryMapper.toDto(saved));
    }

    /**
     * Endpoint to fetch all categories.
     *
     * @return a list of all categories as DTOs
     */
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.getAllCategories().stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }

    /**
     * Endpoint to fetch a single category by its ID.
     *
     * @param id the ID of the category
     * @return the corresponding category DTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return ResponseEntity.ok(CategoryMapper.toDto(category));
    }

    /**
     * Endpoint to update an existing category.
     *
     * @param id the ID of the category to update
     * @param categoryDTO the updated category data
     * @return the updated category as a DTO
     */
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO) {
        Category toUpdate = new Category();
        toUpdate.setName(categoryDTO.getName());
        toUpdate.setDescription(categoryDTO.getDescription());

        Category updated = categoryService.updateCategory(id, toUpdate);
        return ResponseEntity.ok(CategoryMapper.toDto(updated));
    }

    /**
     * Endpoint to delete a category by its ID.
     *
     * @param id the ID of the category to delete
     * @return HTTP 204 No Content if deletion is successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
