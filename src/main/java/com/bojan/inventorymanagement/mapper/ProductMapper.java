package com.bojan.inventorymanagement.mapper;

import com.bojan.inventorymanagement.dto.ProductDTO;
import com.bojan.inventorymanagement.model.Category;
import com.bojan.inventorymanagement.model.Product;
import com.bojan.inventorymanagement.model.Supplier;

public class ProductMapper {

    public static Product toEntity(ProductDTO dto, Category category, Supplier supplier) {
        return Product.builder()
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

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
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
