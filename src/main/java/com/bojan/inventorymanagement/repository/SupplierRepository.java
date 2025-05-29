package com.bojan.inventorymanagement.repository;

import com.bojan.inventorymanagement.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Supplier entities.
 * Inherits standard CRUD operations from JpaRepository.
 */
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
