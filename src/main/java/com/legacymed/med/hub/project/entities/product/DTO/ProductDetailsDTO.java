package com.legacymed.med.hub.project.entities.product.DTO;

import com.legacymed.med.hub.project.entities.category.Category;
import com.legacymed.med.hub.project.entities.product.Product;

public record ProductDetailsDTO(
		String name, 
		String code, 
		Double price, 
		Integer quantity,
		Long ean,
		Category category
		) {

	public ProductDetailsDTO(Product product) {
		this(
			product.getName(), 
			product.getCode(), 
			product.getPrice(), 
			product.getQuantity(),
			product.getEan(),
			product.getCategory()
				);
	}
}
