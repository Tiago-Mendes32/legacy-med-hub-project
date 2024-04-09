package com.legacymed.med.hub.project.entities.product.DTO;

import com.legacymed.med.hub.project.entities.category.Category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewProductDTO(
        @NotNull
        String name,
        @NotNull
        String code,
        @NotNull
        Double price,
        @NotNull
        Integer quantity,
        Category category,
        @Size(min = 13, max = 13)
        Long ean
) {
}
