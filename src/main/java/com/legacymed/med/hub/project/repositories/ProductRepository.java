package com.legacymed.med.hub.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legacymed.med.hub.project.entities.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
