package com.bojan.inventorymanagement.mapper;

import com.bojan.inventorymanagement.dto.SupplierDTO;
import com.bojan.inventorymanagement.model.Supplier;

/**
 * Mapper class to convert between Supplier entity and SupplierDTO.
 * Used to translate data between the database layer (entities) and API layer (DTOs).
 */
public class SupplierMapper {

    /**
     * Converts a SupplierDTO to a Supplier entity.
     *
     * @param dto the SupplierDTO to convert
     * @return a Supplier entity representing the data in the DTO
     */
    public static Supplier toEntity(SupplierDTO dto) {
        return Supplier.builder()
                .name(dto.getName())
                .contactName(dto.getContactName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .build();
    }

    /**
     * Converts a Supplier entity to a SupplierDTO.
     *
     * @param supplier the Supplier entity to convert
     * @return a SupplierDTO that contains the supplier data in a format suitable for the API layer
     */
    public static SupplierDTO toDto(Supplier supplier) {
        return SupplierDTO.builder()
                .name(supplier.getName())
                .contactName(supplier.getContactName())
                .email(supplier.getEmail())
                .phone(supplier.getPhone())
                .address(supplier.getAddress())
                .build();
    }

}
