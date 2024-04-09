package com.legacymed.med.hub.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legacymed.med.hub.project.domain.product.DTO.NewProductDTO;
import com.legacymed.med.hub.project.domain.product.DTO.ProductDetailsDTO;

@RestController
@RequestMapping("/products")
public class productController {

	@PostMapping
	public ProductDetailsDTO insertProduct(@RequestBody NewProductDTO product) {
		System.out.println(product);
		return null;
	}
}
