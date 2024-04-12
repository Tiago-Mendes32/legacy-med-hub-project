package com.legacymed.med.hub.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.legacymed.med.hub.project.entities.category.Category;
import com.legacymed.med.hub.project.entities.category.DTO.CategoryDetailsDTO;
import com.legacymed.med.hub.project.entities.category.DTO.ListCategoriesDTO;
import com.legacymed.med.hub.project.entities.category.DTO.NewCategoryDTO;
import com.legacymed.med.hub.project.entities.category.DTO.UpdateCategoryDTO;
import com.legacymed.med.hub.project.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService service;
	
	@PostMapping
	public ResponseEntity<CategoryDetailsDTO> insertCategory(@RequestBody @Valid NewCategoryDTO categoryDTO, UriComponentsBuilder uriBuilder) {
		Category category = service.insert(new Category(categoryDTO));
		var uri = uriBuilder.path("/categorys/{id}").buildAndExpand(category.getId()).toUri();
		return ResponseEntity.created(uri).body(new CategoryDetailsDTO(category));
	}
	
	@GetMapping
	public ResponseEntity<Page<ListCategoriesDTO>> listAllActiveCategorys(@PageableDefault(size = 20) Pageable pagination){
	    Page<Category> page = service.listAll(pagination);
	    Page<ListCategoriesDTO> dtoPage = page.map(ListCategoriesDTO::new);
	    return ResponseEntity.ok(dtoPage);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDetailsDTO> listById(@PathVariable Long id){
		return ResponseEntity.ok(new CategoryDetailsDTO(service.findById(id)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDetailsDTO> update(@PathVariable Long id, @RequestBody UpdateCategoryDTO data){
		return ResponseEntity.ok(new CategoryDetailsDTO(service.update(id, new Category(data))));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
