package com.bojan.inventorymanagement.service;

import com.bojan.inventorymanagement.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    Supplier saveSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    Optional<Supplier> getSupplierById(Long id);
    void deleteSupplier(Long id);
    Supplier updateSupplier(Long id, Supplier supplier);

}
