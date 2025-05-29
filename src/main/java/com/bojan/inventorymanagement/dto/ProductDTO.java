package com.bojan.inventorymanagement.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

/**
 * Data Transfer Object for Product entity.
 * Used to transfer product data between layers.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long id;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @Min(0)
    private int quantity;

    private String sku;     // Stock Keeping Unit — unique product code

    private String unit;

    private boolean active; // Indicates if the product is active in inventory

    @NotNull
    private Long categoryId;

    @NotNull
    private Long supplierId;

}
