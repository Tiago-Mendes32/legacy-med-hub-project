package com.legacymed.med.hub.project.entities.product.DTO;

import com.legacymed.med.hub.project.entities.category.Category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateProductDTO(

        String name,
        String code,
        Double price,
        @Min(value = 0, message = "Quantity should not be less than 0")
        Integer quantity,
        Category category,
        Long ean
) {
}
