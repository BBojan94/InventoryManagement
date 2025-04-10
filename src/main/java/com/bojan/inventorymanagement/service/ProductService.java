package com.bojan.inventorymanagement.service;

import com.bojan.inventorymanagement.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    void deleteProduct(Long id);
    Product updateProduct(Long id, Product product);

}
