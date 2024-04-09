package com.legacymed.med.hub.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legacymed.med.hub.project.entities.product.Product;
import com.legacymed.med.hub.project.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product insertProduct(Product product) {
		return repository.save(product);
	}
}
