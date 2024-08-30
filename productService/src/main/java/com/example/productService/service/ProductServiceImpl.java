package com.example.productService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productService.dto.ProductRequest;
import com.example.productService.dto.ProductResponseDto;
import com.example.productService.entity.Product;
import com.example.productService.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	
	@Autowired
    private ProductRepository productRepository;
    
    
    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> new ProductResponseDto(product.getId(), product.getName(),product.getDescription(), product.getPrice())).collect(Collectors.toList());
    }
 
    @Override
    public ProductRequest createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product = productRepository.save(product);
        return new ProductRequest(product.getName(), product.getDescription(), product.getPrice());
    }
 
    @Override
    public ProductResponseDto getProuctById(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductResponseDto(product.getId(), product.getName(),product.getDescription(), product.getPrice());
    }

}
