package com.example.InventoryService.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.InventoryService.entity.Inventory;
import com.example.InventoryService.service.InventoryService;

@RestController
@RequestMapping("/inventories")
public class InventoryController

{

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/getAllInventories")
	public List<Inventory> getAllInventories()

	{

		return inventoryService.getAllInventories();

	}

	@GetMapping("/inventoryById")
	public ResponseEntity<Inventory> getInventoryById(@PathVariable int id)

	{

		Optional<Inventory> inventory = inventoryService.getInventoryById(id);

		return inventory.map(value -> new ResponseEntity<>(value, HttpStatus.OK))

				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@GetMapping("/getInventoryByProduct/{pid}")
	public ResponseEntity<Inventory> getInventoryByPid(@PathVariable int pid)

	{
		Inventory inventory = inventoryService.getInventoryByPid(pid);

		return new ResponseEntity<>(inventory, HttpStatus.OK);

	}

	@PostMapping("/createInventory")
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory)

	{

		Inventory inventory1 = inventoryService.createInventory(inventory);

		return new ResponseEntity<>(inventory1, HttpStatus.CREATED);

	}

	@DeleteMapping("/productbyid/{pid}")
	public ResponseEntity<Void> deleteInventoryByPid(@PathVariable int pid)

	{

		inventoryService.deleteInventoryByPid(pid);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}