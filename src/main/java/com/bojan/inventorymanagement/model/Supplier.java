package com.bojan.inventorymanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contactName;

    @Column(name = "contact_email", nullable = false)
    private String email;

    @Column(name = "contact_phone", nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

}
