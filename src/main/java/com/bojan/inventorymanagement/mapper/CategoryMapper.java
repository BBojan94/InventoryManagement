package com.bojan.inventorymanagement.mapper;

import com.bojan.inventorymanagement.dto.CategoryDTO;
import com.bojan.inventorymanagement.model.Category;

/**
 * Mapper class to convert between Category entity and CategoryDTO.
 * Used to translate data between the database layer (entities) and API layer (DTOs).
 */
public class CategoryMapper {

    /**
     * Converts a CategoryDTO to a Category entity.
     *
     * @param dto the CategoryDTO to convert
     * @return a Category entity representing the data in the DTO
     */
    public static Category toEntity(CategoryDTO dto) {
        return Category.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }

    /**
     * Converts a Category entity to a CategoryDTO.
     *
     * @param category the Category entity to convert
     * @return a CategoryDTO that contains the category data in a format suitable for the API layer
     */
    public static CategoryDTO toDto(Category category) {
        return CategoryDTO.builder()
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

}
