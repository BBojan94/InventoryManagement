package com.bojan.inventorymanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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
