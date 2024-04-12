package com.legacymed.med.hub.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legacymed.med.hub.project.entities.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
