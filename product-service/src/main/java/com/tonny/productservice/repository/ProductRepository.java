package com.tonny.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tonny.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
