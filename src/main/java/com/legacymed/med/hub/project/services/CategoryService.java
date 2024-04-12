package com.legacymed.med.hub.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.legacymed.med.hub.project.entities.category.Category;
import com.legacymed.med.hub.project.repositories.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public Category insert(Category category) {
		return repository.save(category);
	}
	
	public Category findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found: ID: " + id));
	}
	
	public Page<Category> listAll(Pageable pagination){
		return repository.findAll(pagination);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Category update(Long id, Category category) {
		return updateData(id, category);
	}

	private Category updateData(Long id, Category category) {
		Category catUpdated = findById(id);
		if(category.getName() != null) {
			catUpdated.setName(category.getName());
		}
		if(category.getCode() != null) {
			catUpdated.setCode(category.getCode());
		}
		insert(catUpdated);
		
		return catUpdated;
	}
}
