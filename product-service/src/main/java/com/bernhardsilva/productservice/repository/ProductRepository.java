package com.bernhardsilva.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bernhardsilva.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

    
}
