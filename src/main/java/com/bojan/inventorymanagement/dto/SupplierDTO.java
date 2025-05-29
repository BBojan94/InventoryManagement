package com.bojan.inventorymanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * Data Transfer Object for Supplier entity.
 * Used to transfer supplier data between layers.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierDTO {

    @NotBlank
    private String name;

    private String contactName;

    @Email
    private String email;

    private String phone;

    private String address;

}
