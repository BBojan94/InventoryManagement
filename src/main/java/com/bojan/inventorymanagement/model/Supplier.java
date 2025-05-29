package com.bojan.inventorymanagement.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a supplier in the inventory system.
 * Contains basic contact information and address for the supplier entity.
 */
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

    /** Company or business name of the supplier */
    @Column(nullable = false)
    private String name;

    /** Name of the contact person representing the supplier */
    @Column(nullable = false)
    private String contactName;

    /** Email address for the supplier's contact person */
    @Column(name = "contact_email", nullable = false)
    private String email;

    /** Phone number for the supplier's contact person */
    @Column(name = "contact_phone", nullable = false)
    private String phone;

    /** Physical address of the supplier */
    @Column(nullable = false)
    private String address;

}
