package com.bojan.inventorymanagement.service;

import com.bojan.inventorymanagement.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category saveCategory(Category category);
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    void deleteCategory(Long id);
    Category updateCategory(Long id, Category category);

}
