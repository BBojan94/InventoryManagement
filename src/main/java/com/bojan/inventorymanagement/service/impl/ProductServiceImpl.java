package com.bojan.inventorymanagement.service.impl;

import com.bojan.inventorymanagement.model.Product;
import com.bojan.inventorymanagement.repository.ProductRepository;
import com.bojan.inventorymanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the ProductService interface.
 * Handles business logic and data access operations for Product entities.
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // Injected repository for handling business logic
    private final ProductRepository productRepository;

    /**
     * Saves a new product or updates an existing one.
     *
     * @param product the product to save
     * @return the saved product instance
     */
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Retrieves a list of all products from the database.
     *
     * @return list of all products
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a single product by its ID.
     *
     * @param id the ID of the product
     * @return Optional containing the product if found, empty otherwise
     */
    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     */
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * Updates an existing product with new data.
     *
     * @param id the ID of the product to update
     * @param updatedProduct the new product data
     * @return the updated product entity
     * @throws RuntimeException if the product with the given ID does not exist
     */
    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            // Update fields with new values
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
//            product.setSku(updatedProduct.getSku());
            product.setUnit(updatedProduct.getUnit());
//            product.setActive(updatedProduct.isActive());
            product.setCategory(updatedProduct.getCategory());
            product.setSupplier(updatedProduct.getSupplier());

            // Save the updated product
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

}
