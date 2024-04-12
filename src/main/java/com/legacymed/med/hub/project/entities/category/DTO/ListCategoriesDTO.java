package com.legacymed.med.hub.project.entities.category.DTO;

import com.legacymed.med.hub.project.entities.category.Category;

public record ListCategoriesDTO(
		String name, 
		String code 
		) {

	public ListCategoriesDTO(Category category) {
		this(
			category.getName(), 
			category.getCode()
			);
	}
}
