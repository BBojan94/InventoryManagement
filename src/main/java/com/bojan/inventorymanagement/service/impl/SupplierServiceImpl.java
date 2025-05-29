package com.bojan.inventorymanagement.service.impl;

import com.bojan.inventorymanagement.model.Supplier;
import com.bojan.inventorymanagement.repository.SupplierRepository;
import com.bojan.inventorymanagement.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the SupplierService interface.
 * Handles business logic and data access operations for Supplier entities.
 */
@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    // Injected repository for handling business logic
    private final SupplierRepository supplierRepository;

    /**
     * Saves a new supplier or updates an existing one.
     *
     * @param supplier the supplier to save
     * @return the saved supplier instance
     */
    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    /**
     * Retrieves a list of all suppliers from the database.
     *
     * @return list of all suppliers
     */
    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    /**
     * Retrieves a single supplier by its ID.
     *
     * @param id the ID of the supplier
     * @return Optional containing the supplier if found, empty otherwise
     */
    @Override
    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    /**
     * Deletes a supplier by its ID.
     *
     * @param id the ID of the supplier to delete
     */
    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    /**
     * Updates an existing supplier with new data.
     *
     * @param id the ID of the supplier to update
     * @param updatedSupplier the new supplier data
     * @return the updated supplier entity
     * @throws RuntimeException if the supplier with the given ID does not exist
     */
    @Override
    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        return supplierRepository.findById(id).map(supplier -> {
            supplier.setName(updatedSupplier.getName());
            supplier.setContactName(updatedSupplier.getContactName());
            supplier.setEmail(updatedSupplier.getEmail());
            supplier.setPhone(updatedSupplier.getPhone());
            supplier.setAddress(updatedSupplier.getAddress());
            return supplierRepository.save(supplier);
        }).orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

}
