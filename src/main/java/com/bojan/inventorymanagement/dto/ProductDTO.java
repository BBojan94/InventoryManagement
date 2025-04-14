package com.bojan.inventorymanagement.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long id;    // Unique identifier for the product

    @NotBlank
    private String name;

    private String description;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @Min(0)
    private int quantity;

    private String sku; // Stock Keeping Unit — unique product code

    private String unit;    // Unit of measure (e.g., "pcs", "kg")

    private boolean active; // Indicates if the product is active in inventory

    @NotNull
    private Long categoryId;

    @NotNull
    private Long supplierId;

}
