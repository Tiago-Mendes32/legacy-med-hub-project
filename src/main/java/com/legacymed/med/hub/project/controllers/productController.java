package com.legacymed.med.hub.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.legacymed.med.hub.project.entities.product.Product;
import com.legacymed.med.hub.project.entities.product.DTO.NewProductDTO;
import com.legacymed.med.hub.project.entities.product.DTO.ProductDetailsDTO;
import com.legacymed.med.hub.project.repositories.ProductRepository;

@RestController
@RequestMapping("/products")
public class productController {

	@Autowired
	ProductRepository repository;
	
	@PostMapping
	public ResponseEntity<ProductDetailsDTO> insertProduct(@RequestBody NewProductDTO productDTO, UriComponentsBuilder uriBuilder) {
		Product product = repository.save(new Product(productDTO));
		var uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDetailsDTO(product));
	}
}
