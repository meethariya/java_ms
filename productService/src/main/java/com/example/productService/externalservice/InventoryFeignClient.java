package com.example.productService.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.productService.entity.Inventory;



@FeignClient(name="inventory-service")
public interface InventoryFeignClient {
	
	@GetMapping("/getInventoryByProduct/{pid}")
	public ResponseEntity<Inventory> getInventoryByPid(@PathVariable int pid);

}
