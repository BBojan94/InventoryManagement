package com.bojan.inventorymanagement.repository;

import com.bojan.inventorymanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Product entities.
 * Inherits standard CRUD operations from JpaRepository.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
