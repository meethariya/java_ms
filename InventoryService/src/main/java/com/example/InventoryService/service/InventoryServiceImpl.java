package com.example.InventoryService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.InventoryService.Dto.Product;
import com.example.InventoryService.entity.Inventory;
import com.example.InventoryService.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    
    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<Inventory> getInventoryById(int id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public Inventory getInventoryByPid(int pid) {
        return inventoryRepository.findByPid(pid);
    }

    @Override
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteInventoryByPid(int pid) {
        Inventory inventory = inventoryRepository.findByPid(pid);
        if (inventory != null) {
            inventoryRepository.delete(inventory);
        }
    
    }
    
    public Product getProductById(int pid) {
    	String url = "http://localhost:8082/api/product/getProductById/{id}";
        Product product = restTemplate.getForObject(url, Product.class, pid);
        return product;
    }
}