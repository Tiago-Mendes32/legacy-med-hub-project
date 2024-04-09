package com.legacymed.med.hub.project.domain.product.DTO;

import com.legacymed.med.hub.project.domain.category.Category;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record NewProductDTO(
		@NotBlank
		String name, 
		@NotBlank
		String code, 
		@NotBlank
		Double price,
		@NotBlank
		Integer quantity,
		Category category,
		@Pattern(regexp = "\\d{13}")
		Long ean
		) {
}
