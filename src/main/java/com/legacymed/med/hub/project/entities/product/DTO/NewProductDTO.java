package com.legacymed.med.hub.project.entities.product.DTO;

import com.legacymed.med.hub.project.entities.category.Category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewProductDTO(
        @NotBlank(message = "Name not be null")
        String name,
        @NotBlank(message = "Code not be null")
        String code,
        @NotNull(message = "Price not be null")
        Double price,
        @NotNull(message = "Quantity not be null")
        @Min(value = 1, message = "Quantity should not be less than 1")
        Integer quantity,
        Category category,
        Long ean
) {
}
