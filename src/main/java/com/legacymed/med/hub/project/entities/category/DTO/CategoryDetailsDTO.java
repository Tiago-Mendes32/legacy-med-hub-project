package com.legacymed.med.hub.project.entities.category.DTO;

import com.legacymed.med.hub.project.entities.category.Category;
import com.legacymed.med.hub.project.entities.category.Category;

public record CategoryDetailsDTO(
		String name, 
		String code
		) {

	public CategoryDetailsDTO(Category category) {
		this(
			category.getName(), 
			category.getCode(
					));
	}
}
