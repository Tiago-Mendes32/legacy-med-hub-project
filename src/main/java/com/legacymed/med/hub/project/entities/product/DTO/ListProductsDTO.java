package com.legacymed.med.hub.project.entities.product.DTO;

import com.legacymed.med.hub.project.entities.product.Product;

public record ListProductsDTO(
		String name, 
		String code, 
		Double price
		) {

	public ListProductsDTO(Product product) {
		this(
			product.getName(), 
			product.getCode(), 
			product.getPrice());
	}
}
