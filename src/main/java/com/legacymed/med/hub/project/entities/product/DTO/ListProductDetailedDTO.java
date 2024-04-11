package com.legacymed.med.hub.project.entities.product.DTO;

import com.legacymed.med.hub.project.entities.product.Product;

public record ListProductDetailedDTO(
		String name,
		String code,
		Double price,
		Integer quantity,
		Long ean
		) {

	public ListProductDetailedDTO(Product product) {
		this(
				product.getName(),
				product.getCode(),
				product.getPrice(),
				product.getQuantity(),
				product.getEan());
	}
			
}
