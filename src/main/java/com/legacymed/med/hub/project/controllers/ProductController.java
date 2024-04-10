package com.legacymed.med.hub.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.legacymed.med.hub.project.entities.product.Product;
import com.legacymed.med.hub.project.entities.product.DTO.ListProductsDTO;
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
	
	@GetMapping
	public ResponseEntity<Page<ListProductsDTO>> listAll(@PageableDefault(size = 10) Pageable pagination){
	    Page<Product> page = service.listAllAssets(pagination);
	    Page<ListProductsDTO> dtoPage = page.map(ListProductsDTO::new);
	    return ResponseEntity.ok(dtoPage);
	}
}
