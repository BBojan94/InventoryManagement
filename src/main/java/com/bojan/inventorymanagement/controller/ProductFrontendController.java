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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling frontend operations related to products.
 * Provides endpoints for listing, creating, editing, viewing, and deleting products.
 */
@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductFrontendController {

    // Injected services for handling business logic
    private final ProductService productService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    /**
     * Display all products.
     * Adds the list of products to the model and returns the view for listing.
     */
    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/list";  // Returns product/list.html
    }

    /**
     * Show form for creating a new product.
     * Prepares an empty ProductDTO and lists of categories and suppliers.
     */
    @GetMapping("/new")
    public String createProductForm(Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "product/create";  // Returns product/create.html
    }

    /**
     * Handle form submission for creating a new product.
     * Converts ProductDTO to Product entity, validates category and supplier, and saves it.
     */
    @PostMapping("/new")
    public String saveProduct(@ModelAttribute ProductDTO productDTO) {
        // Resolve category and supplier from their IDs
        Category category = categoryService.getCategoryById(productDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        Supplier supplier = supplierService.getSupplierById(productDTO.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        // Convert DTO to entity and save
        productService.saveProduct(ProductMapper.toEntity(productDTO, category, supplier));
        return "redirect:/products";    // Redirect to product list view
    }

    /**
     * Show detailed view of a product by its ID.
     * If the product is not found, an exception is thrown.
     */
    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        model.addAttribute("product", product);
        return "product/details";  // Returns product/details.html
    }

    /**
     * Show form for editing an existing product.
     * Populates the form with the product's current data.
     */
    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        model.addAttribute("product", ProductMapper.toDTO(product));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "product/edit";  // Returns product/edit.html
    }

    /**
     * Handle form submission for updating a product.
     * Converts DTO back to entity, resolves foreign keys, and performs update.
     */
    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute ProductDTO productDTO) {
        Category category = categoryService.getCategoryById(productDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        Supplier supplier = supplierService.getSupplierById(productDTO.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        productService.updateProduct(id, ProductMapper.toEntity(productDTO, category, supplier));
        return "redirect:/products";  // Redirect to product list
    }

    /**
     * Delete a product by its ID.
     * After deletion, redirects back to the product list.
     */
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";  // Redirect to product list
    }
}
