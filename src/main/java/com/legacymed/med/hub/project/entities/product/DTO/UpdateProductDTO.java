package com.legacymed.med.hub.project.entities.product.DTO;

import jakarta.validation.constraints.Min;

public record UpdateProductDTO(

        String name,
        String code,
        Double price,
        @Min(value = 0, message = "Quantity should not be less than 0")
        Integer quantity,
        Long categoryId,
        Long ean
) {
}
