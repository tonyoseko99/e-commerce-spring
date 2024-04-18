package com.tonny.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
