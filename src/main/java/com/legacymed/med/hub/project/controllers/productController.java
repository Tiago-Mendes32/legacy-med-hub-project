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
import com.legacymed.med.hub.project.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping
	public ResponseEntity<ProductDetailsDTO> insertProduct(@RequestBody @Valid NewProductDTO productDTO, UriComponentsBuilder uriBuilder) {
		Product product = service.insert(new Product(productDTO));
		var uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDetailsDTO(product));
	}
}
