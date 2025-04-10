package com.bojan.inventorymanagement.repository;

import com.bojan.inventorymanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
