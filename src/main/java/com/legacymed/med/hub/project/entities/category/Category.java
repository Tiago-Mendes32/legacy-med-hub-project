package com.legacymed.med.hub.project.entities.category;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.legacymed.med.hub.project.entities.category.DTO.NewCategoryDTO;
import com.legacymed.med.hub.project.entities.category.DTO.UpdateCategoryDTO;
import com.legacymed.med.hub.project.entities.product.Product;
import com.legacymed.med.hub.project.entities.status.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity(name = "category")
@Table(name = "categories")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String code;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
    private List<Product> products;
	
	public Category() {
	}

	public Category(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public Category(@Valid NewCategoryDTO categoryDTO) {
		this.name = categoryDTO.name();
		this.code = categoryDTO.code();
	}

	public Category(UpdateCategoryDTO data) {
		this.name = data.name();
		this.code = data.code();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(code, other.code) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
}
