package com.legacymed.med.hub.project.entities.category.DTO;

import jakarta.validation.constraints.NotBlank;

public record NewCategoryDTO(
        @NotBlank(message = "Name not be null")
        String name,
        @NotBlank(message = "Code not be null")
        String code
) {
}
