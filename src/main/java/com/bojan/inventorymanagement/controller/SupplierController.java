package com.bojan.inventorymanagement.controller;

import com.bojan.inventorymanagement.dto.SupplierDTO;
import com.bojan.inventorymanagement.exception.ResourceNotFoundException;
import com.bojan.inventorymanagement.model.Supplier;
import com.bojan.inventorymanagement.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierDTO> createSupplier(@Valid @RequestBody SupplierDTO dto) {
        Supplier supplier = new Supplier();
        supplier.setName(dto.getName());
        supplier.setContactName(dto.getContactName());
        supplier.setEmail(dto.getEmail());
        supplier.setPhone(dto.getPhone());
        supplier.setAddress(dto.getAddress());

        Supplier saved = supplierService.saveSupplier(supplier);
        return ResponseEntity.ok(mapToDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        List<SupplierDTO> suppliers = supplierService.getAllSuppliers().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierService.getSupplierById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        return ResponseEntity.ok(mapToDTO(supplier));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @Valid @RequestBody SupplierDTO dto) {
        Supplier updatedData = new Supplier();
        updatedData.setName(dto.getName());
        updatedData.setContactName(dto.getContactName());
        updatedData.setEmail(dto.getEmail());
        updatedData.setPhone(dto.getPhone());
        updatedData.setAddress(dto.getAddress());

        Supplier updated = supplierService.updateSupplier(id, updatedData);
        return ResponseEntity.ok(mapToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

    private SupplierDTO mapToDTO(Supplier s) {
        return SupplierDTO.builder()
                .name(s.getName())
                .contactName(s.getContactName())
                .email(s.getEmail())
                .phone(s.getPhone())
                .address(s.getAddress())
                .build();
    }

}
