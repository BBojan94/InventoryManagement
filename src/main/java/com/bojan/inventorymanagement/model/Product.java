package com.bojan.inventorymanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * Represents a product in the inventory system.
 * Contains basic product details such as name, price, quantity,
 * and relations to its category and supplier.
 */
@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Name of the product (e.g. "Apple Juice") */
    @Column(nullable = false)
    private String name;

    /** Description of the product */
    @Column(nullable = false)
    private String description;

    /** Price of a single unit of the product */
    @Column(nullable = false)
    private BigDecimal price;

    /** Available quantity of the product in stock */
    @Column(nullable = false)
    private int quantity;

//    private String sku;     // Stock Keeping Unit

    /** Unit of measurement (e.g. "kg", "liters", "pcs") */
    private String unit;

//    private boolean active = true;

    /** The category this product belongs to */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /** The supplier providing this product */
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

}
