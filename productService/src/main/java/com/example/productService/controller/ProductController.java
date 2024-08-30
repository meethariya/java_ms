package com.example.productService.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productService.Exception.ProductNotFoundException;
import com.example.productService.dto.ProductRequest;
import com.example.productService.dto.ProductResponseDto;
import com.example.productService.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/product")
public class ProductController{
	
	
	@Autowired
	private ProductServiceImpl productService;

	@PostMapping("/addProduct")
	public ResponseEntity<ProductRequest> createProduct(@RequestBody ProductRequest productRequest)
	{
		//return productService.createProduct(productRequest);
		 ProductRequest createdProduct = productService.createProduct(productRequest);
	        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	@GetMapping("/getAllProducts")
	public List<ProductRequest> getAllProducts()
	{
//		if(productService.getAllProducts().isEmpty()) {
//			throw new ProductNotFoundException("No Products Available");
//		}
		//return productService.getAllProducts();
		
		List<ProductResponseDto> products = productService.getAllProducts();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found");
        }
        return products.stream()
                .map(product -> new ProductRequest(product.getName(), product.getDescription(), product.getPrice()))
                .collect(Collectors.toList());
	}
	
	@GetMapping("/getProuctById/{id}")
	public ResponseEntity<ProductResponseDto> getProductById(@PathVariable int id)
	{
		return new ResponseEntity<> (productService.getProuctById(id),HttpStatus.FOUND);
	}

}
