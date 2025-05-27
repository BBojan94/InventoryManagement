package com.bojan.inventorymanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

    @NotBlank
    private String name;

    private String description;

}
