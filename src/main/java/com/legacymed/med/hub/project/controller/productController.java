package com.legacymed.med.hub.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class productController {

	@PostMapping
	public ProductDetailsDTO insertProduct(NewProductData product) {
		System.out.println("Usuário cadastrado");
	}
}
