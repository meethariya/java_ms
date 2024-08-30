package com.example.productService.service;

import java.util.List;

import com.example.productService.dto.ProductRequest;
import com.example.productService.dto.ProductResponseDto;

public interface ProductService {
	
	
	List<ProductResponseDto> getAllProducts();
	 
	ProductRequest createProduct(ProductRequest productRequest);

	ProductResponseDto getProuctById(int id);

}
