package com.legacymed.med.hub.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.legacymed.med.hub.project.entities.category.Category;
import com.legacymed.med.hub.project.entities.product.Product;
import com.legacymed.med.hub.project.entities.product.DTO.NewProductDTO;
import com.legacymed.med.hub.project.entities.product.DTO.UpdateProductDTO;
import com.legacymed.med.hub.project.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoryService categoryService;
	
	private void insert(Product product) {
		repository.save(product);
	}
	
	public Product insertFromDTO(@Valid NewProductDTO productDTO) {
		Category category = categoryService.findById(productDTO.categoryId());
		Product product = new Product(productDTO.name(), productDTO.code(), productDTO.price(), productDTO.quantity(), productDTO.ean(), category);
		return repository.save(product);
	}
	
	public Product findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found: ID: " + id));
	}
	
	public Page<Product> listAll(Pageable pagination){
		return repository.findAll(pagination);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void deleteByCode(String code) {
		repository.deleteByCode(code);
		
	}
	
	public Product update(Long id, Product product) {
		return updateData(id, product);
	}

	public Product convertUpdateDTO(UpdateProductDTO prodDTO) {
		return new Product(
				prodDTO.name(),
				prodDTO.code(),
				prodDTO.price(),
				prodDTO.quantity(),
				prodDTO.ean(),
				categoryService.findById(prodDTO.categoryId())
				);
	}
	
	private Product updateData(Long id, Product product) {
		Product prodUpdated = findById(id);
		if(product.getName() != null) {
		prodUpdated.setName(product.getName());
		}
		if(product.getCode() != null) {
		prodUpdated.setCode(product.getCode());
		}
		if(product.getPrice() != null) {
		prodUpdated.setPrice(product.getPrice());
		}
		if(product.getQuantity() != null) {
		prodUpdated.setQuantity(product.getQuantity());
		}
		if(product.getEan() != null) {
		prodUpdated.setEan(product.getEan());
		}
		if(product.getCategory() != null) {
		prodUpdated.setCategory(product.getCategory());
		}
		insert(prodUpdated);
		
		return prodUpdated;
	}
}
