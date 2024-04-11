package com.legacymed.med.hub.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.legacymed.med.hub.project.entities.product.Product;
import com.legacymed.med.hub.project.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product insert(Product product) {
		return repository.save(product);
	}
	
	public Product findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	public Page<Product> listAll(Pageable pagination){
		return repository.findAll(pagination);
	}
	
	public void desative(Long id) {
		repository.deleteById(id);
	}
	
	public Product update(Long id, Product product) {
		return updateData(id, product);
	}

	private Product updateData(Long id, Product product) {
		Product prodUpdated = findById(id);
		
		prodUpdated.setName(product.getName());
		prodUpdated.setCode(product.getCode());
		prodUpdated.setPrice(product.getPrice());
		prodUpdated.setQuantity(product.getQuantity());
		prodUpdated.setEan(product.getEan());
		prodUpdated.setCategory(product.getCategory());
		insert(prodUpdated);
		
		return prodUpdated;
	}
}
