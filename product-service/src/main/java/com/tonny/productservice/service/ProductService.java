package com.tonny.productservice.service;

import com.tonny.productservice.dto.ProductRequestDto;
import com.tonny.productservice.dto.ProductResponseDto;
import com.tonny.productservice.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.tonny.productservice.model.Product;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequestDto productRequestDto){
        Product product = mapToProductRequest(productRequestDto);
        productRepository.save(product);
        log.info("Product created. Product name: {}", product.getName());

    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        log.info("Retrieved all products. Total products: {}", products.size());
        return products.stream().map(this::mapToProductResponse).toList();
    }

    public ProductResponseDto getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Product not found")
        );
        log.info("Retrieved product by id. Product name: {}", product.getName());
        return mapToProductResponse(product);
    }

    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Product not found")
        );
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setQuantity(productRequestDto.getQuantity());
        productRepository.save(product);
        log.info("Product updated. Product name: {}", product.getName());
        return mapToProductResponse(product);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Product not found")
        );
        productRepository.delete(product);
        log.info("Product deleted. Product name: {}", product.getName());
    }

    private ProductResponseDto mapToProductResponse(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    private Product mapToProductRequest(ProductRequestDto productRequestDto) {
        return Product.builder()
                .name(productRequestDto.getName())
                .description(productRequestDto.getDescription())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .build();
    }
}
