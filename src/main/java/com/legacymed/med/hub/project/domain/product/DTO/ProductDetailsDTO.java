package com.legacymed.med.hub.project.domain.product.DTO;

import com.legacymed.med.hub.project.domain.category.Category;
import com.legacymed.med.hub.project.domain.product.Product;

public record ProductDetailsDTO(
		String name, 
		String code, 
		Double price, 
		Integer quantity,
		Category category,
		Long ean
		) {

	public ProductDetailsDTO(Product product) {
		this(
			product.getName(), 
			product.getCode(), 
			product.getPrice(), 
			product.getQuantity(), 
			product.getCategory(), 
			product.getEan());
	}
}
