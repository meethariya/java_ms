package com.example.productService.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
private int id;
private String name;
private String description;
private BigDecimal price;
private InventoryDto inventry;
public InventoryDto getInventry() {
	return inventry;
}
public void setInventry(InventoryDto inventry) {
	this.inventry = inventry;
}

public ProductResponseDto(int id, String name, String description, BigDecimal price, InventoryDto inventry) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
	this.inventry = inventry;
}
public ProductResponseDto() {
	super();
	// TODO Auto-generated constructor stub
}
public ProductResponseDto(int id, String name, String description, BigDecimal price) {
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}
public String getDescription() {
	// TODO Auto-generated method stub
	return null;
}
public void setDescription(String description) {
	this.description = description;
}





}
