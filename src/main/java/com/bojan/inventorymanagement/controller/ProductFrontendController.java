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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductFrontendController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    @Autowired
    public ProductFrontendController(ProductService productService, CategoryService categoryService, SupplierService supplierService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }

    // Display all products
    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/list";  // returns the view (product/list.html)
    }

    // Show form to create a new product
    @GetMapping("/new")
    public String createProductForm(Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "product/create";  // returns the view (product/create.html)
    }

    // Save new product
    @PostMapping("/new")
    public String saveProduct(@ModelAttribute ProductDTO productDTO) {
        // Convert DTO to entity and save
        Category category = categoryService.getCategoryById(productDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Supplier supplier = supplierService.getSupplierById(productDTO.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        Product product = productService.saveProduct(ProductMapper.toEntity(productDTO, category, supplier));
        return "redirect:/products";  // Redirect to the product list
    }

    // Show product details
    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        model.addAttribute("product", product);
        return "product/details";  // returns the view (product/details.html)
    }

    // Show form to edit product
    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        model.addAttribute("product", ProductMapper.toDTO(product));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "product/edit";  // returns the view (product/edit.html)
    }

    // Save updated product
    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute ProductDTO productDTO) {
        Category category = categoryService.getCategoryById(productDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Supplier supplier = supplierService.getSupplierById(productDTO.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        productService.updateProduct(id, ProductMapper.toEntity(productDTO, category, supplier));
        return "redirect:/products";  // Redirect to the product list
    }

    // Delete a product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";  // Redirect to the product list
    }
}
