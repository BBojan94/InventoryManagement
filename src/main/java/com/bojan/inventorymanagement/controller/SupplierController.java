package com.bojan.inventorymanagement.controller;

import com.bojan.inventorymanagement.dto.SupplierDTO;
import com.bojan.inventorymanagement.exception.ResourceNotFoundException;
import com.bojan.inventorymanagement.mapper.SupplierMapper;
import com.bojan.inventorymanagement.model.Supplier;
import com.bojan.inventorymanagement.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST Controller for handling supplier-related endpoints.
 * Provides CRUD operations for Supplier resources.
 */
@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {

    // Injected service for handling business logic
    private final SupplierService supplierService;

    /**
     * Endpoint to create a new supplier.
     *
     * @param supplierDTO the supplier data to be created
     * @return the created supplier as a DTO
     */
    @PostMapping
    public ResponseEntity<SupplierDTO> createSupplier(@Valid @RequestBody SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setName(supplierDTO.getName());
        supplier.setContactName(supplierDTO.getContactName());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setPhone(supplierDTO.getPhone());
        supplier.setAddress(supplierDTO.getAddress());

        Supplier saved = supplierService.saveSupplier(supplier);
        return ResponseEntity.ok(SupplierMapper.toDto(saved));
    }

    /**
     * Endpoint to fetch all suppliers.
     *
     * @return a list of all suppliers as DTOs
     */
    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        List<SupplierDTO> suppliers = supplierService.getAllSuppliers().stream()
                .map(SupplierMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(suppliers);
    }

    /**
     * Endpoint to fetch a single supplier by its ID.
     *
     * @param id the ID of the supplier
     * @return the corresponding supplier DTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierService.getSupplierById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        return ResponseEntity.ok(SupplierMapper.toDto(supplier));
    }

    /**
     * Endpoint to update an existing supplier.
     *
     * @param id the ID of the supplier to update
     * @param supplierDTO the updated supplier data
     * @return the updated supplier as a DTO
     */
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @Valid @RequestBody SupplierDTO supplierDTO) {
        Supplier updatedData = new Supplier();
        updatedData.setName(supplierDTO.getName());
        updatedData.setContactName(supplierDTO.getContactName());
        updatedData.setEmail(supplierDTO.getEmail());
        updatedData.setPhone(supplierDTO.getPhone());
        updatedData.setAddress(supplierDTO.getAddress());

        Supplier updated = supplierService.updateSupplier(id, updatedData);
        return ResponseEntity.ok(SupplierMapper.toDto(updated));
    }

    /**
     * Endpoint to delete a supplier by its ID.
     *
     * @param id the ID of the supplier to delete
     * @return HTTP 204 No Content if deletion is successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

}
