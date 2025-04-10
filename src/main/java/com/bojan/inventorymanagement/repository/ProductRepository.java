package com.bojan.inventorymanagement.repository;

import com.bojan.inventorymanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
