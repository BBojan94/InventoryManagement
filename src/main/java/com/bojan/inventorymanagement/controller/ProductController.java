package com.bojan.inventorymanagement.controller;

import com.bojan.inventorymanagement.dto.ProductDTO;
import com.bojan.inventorymanagement.exception.ResourceNotFoundException;
import com.bojan.inventorymanagement.mapper.ProductMapper;
import com.bojan.inventorymanagement.model.Category;
import com.bojan.inventorymanagement.model.Product;
import com.bojan.inventorymanagement.model.Supplier;
import com.bojan.inventorymanagement.service.CategoryService;
import com.bojan.inventorymanagement.service.ProductService;
import com.bojan.inventorymanagement.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST Controller for handling product-related endpoints.
 * Provides CRUD operations for Product resources.
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    /**
     * Constructor-based injection for service dependencies.
     */
    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, SupplierService supplierService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }

    /**
     * Endpoint to create a new product.
     *
     * @param productDTO the product data to be created
     * @return the created product as a DTO
     */
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        Category category = categoryService.getCategoryById(productDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Supplier supplier = supplierService.getSupplierById(productDTO.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        Product product = ProductMapper.toEntity(productDTO, category, supplier);
        Product saved = productService.saveProduct(product);
        return ResponseEntity.ok(ProductMapper.toDTO(saved));
    }

    /**
     * Endpoint to fetch all products.
     *
     * @return a list of all products as DTOs
     */
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts().stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    /**
     * Endpoint to fetch a single product by its ID.
     *
     * @param id the ID of the product
     * @return the corresponding product DTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return ResponseEntity.ok(ProductMapper.toDTO(product));
    }

    /**
     * Endpoint to update an existing product.
     *
     * @param id the ID of the product to update
     * @param productDTO the updated product data
     * @return the updated product as a DTO
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
        Category category = categoryService.getCategoryById(productDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Supplier supplier = supplierService.getSupplierById(productDTO.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        Product updatedEntity = ProductMapper.toEntity(productDTO, category, supplier);
        Product updated = productService.updateProduct(id, updatedEntity);
        return ResponseEntity.ok(ProductMapper.toDTO(updated));
    }

    /**
     * Endpoint to delete a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return HTTP 204 No Content if deletion is successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
