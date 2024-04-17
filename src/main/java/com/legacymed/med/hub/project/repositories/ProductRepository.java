package com.legacymed.med.hub.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legacymed.med.hub.project.entities.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	void deleteByCode(String code);
}
