package com.bojan.inventorymanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * Data Transfer Object for Category entity.
 * Used to transfer category data between layers.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

    @NotBlank
    private String name;

    private String description;

}
