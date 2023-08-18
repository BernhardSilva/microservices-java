package com.bernhardsilva.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bernhardsilva.productservice.dto.ProductRequest;
import com.bernhardsilva.productservice.dto.ProductResponse;
import com.bernhardsilva.productservice.model.Product;
import com.bernhardsilva.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
        .name(productRequest.getName())
        .price(productRequest.getPrice())
        .description(productRequest.getDescription())
        .build();


        productRepository.save(product);
        log.info("Product {} is saved", product.getId());

    }

    public List<ProductResponse> getAllProducts(){

    List<Product> products = productRepository.findAll();

    return products.stream().map(this::mapProductResponse).toList();

    }
        
           
    private ProductResponse mapProductResponse(Product product){
        return ProductResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .description(product.getDescription())
        .build();
    }
    
}
