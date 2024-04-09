package com.legacymed.med.hub.project.entities.product;

import java.io.Serializable;
import java.util.Objects;

import com.legacymed.med.hub.project.entities.category.Category;
import com.legacymed.med.hub.project.entities.product.DTO.NewProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "product")
@Table(name = "products")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String code;
	private Double price;
	private Integer quantity;
	private Long ean;
	
	@ManyToOne
	private Category category;
	
	public Product() {
	}

	public Product(String name, String code, Double price, Integer quantity, Long ean, Category category) {
		this.name = name;
		this.code = code;
		this.price = price;
		this.quantity = quantity;
		this.ean = ean;
		this.category = category;
	}
	
	public Product(NewProductDTO prodDTO) {
		this.name = prodDTO.name();
		this.code = prodDTO.code();
		this.price = prodDTO.price();
		this.quantity = prodDTO.quantity();
		this.ean = prodDTO.ean();
		this.category = prodDTO.category();
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getEan() {
		return ean;
	}

	
	public void setEan(Long ean) {
		this.ean = ean;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
}
