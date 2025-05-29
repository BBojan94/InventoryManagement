package com.bojan.inventorymanagement.service.impl;

import com.bojan.inventorymanagement.model.Category;
import com.bojan.inventorymanagement.repository.CategoryRepository;
import com.bojan.inventorymanagement.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the CategoryService interface.
 * Handles business logic and data access operations for Category entities.
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    // Injected repository for handling business logic
    private final CategoryRepository categoryRepository;

    /**
     * Saves a new category or updates an existing one.
     *
     * @param category the category to save
     * @return the saved category instance
     */
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Retrieves a list of all categories from the database.
     *
     * @return list of all categories
     */
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Retrieves a single category by its ID.
     *
     * @param id the ID of the category
     * @return Optional containing the category if found, empty otherwise
     */
    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id the ID of the category to delete
     */
    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    /**
     * Updates an existing category with new data.
     *
     * @param id the ID of the category to update
     * @param updatedCategory the new category data
     * @return the updated category entity
     * @throws RuntimeException if the category with the given ID does not exist
     */
    @Override
    public Category updateCategory(Long id, Category updatedCategory) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            category.setDescription(updatedCategory.getDescription());
            return categoryRepository.save(category);
        }).orElseThrow(() -> new RuntimeException("Category not found"));
    }

}
