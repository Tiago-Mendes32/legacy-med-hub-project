package com.legacymed.med.hub.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legacymed.med.hub.project.entities.category.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
