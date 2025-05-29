package com.bojan.inventorymanagement.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a category of products in the inventory system.
 * Each category has a name and a description and can be associated with multiple products.
 */
@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Name of the category (e.g. Electronics, Beverages) */
    @Column(nullable = false)
    private String name;

    /** Description of the category purpose or content */
    @Column(nullable = false)
    private String description;

}
