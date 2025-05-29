package com.bojan.inventorymanagement.repository;

import com.bojan.inventorymanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Category entities.
 * Inherits standard CRUD operations from JpaRepository.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
