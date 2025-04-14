package com.bojan.inventorymanagement.mapper;

import com.bojan.inventorymanagement.dto.ProductDTO;
import com.bojan.inventorymanagement.model.Category;
import com.bojan.inventorymanagement.model.Product;
import com.bojan.inventorymanagement.model.Supplier;

/**
 * Mapper class to convert between Product entity and ProductDTO.
 * Used to translate data between the database layer (entities) and API layer (DTOs).
 */
public class ProductMapper {

    /**
     * Converts a ProductDTO to a Product entity.
     *
     * @param dto the ProductDTO to convert
     * @param category the category to associate with the product
     * @param supplier the supplier to associate with the product
     * @return a Product entity representing the data in the DTO
     */
    public static Product toEntity(ProductDTO dto, Category category, Supplier supplier) {
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .sku(dto.getSku())
                .unit(dto.getUnit())
//                .active(dto.isActive())
                .category(category)
                .supplier(supplier)
                .build();
    }

    /**
     * Converts a Product entity to a ProductDTO.
     *
     * @param product the Product entity to convert
     * @return a ProductDTO that contains the product data in a format suitable for the API layer
     */
    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .sku(product.getSku())
                .unit(product.getUnit())
//                .active(product.isActive())
                .categoryId(product.getCategory().getId())
                .supplierId(product.getSupplier().getId())
                .build();
    }

}
