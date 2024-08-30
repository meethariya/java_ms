package com.example.InventoryService.service;


import java.util.List;
import java.util.Optional;

import com.example.InventoryService.entity.Inventory;

public interface InventoryService {
    List<Inventory> getAllInventories();
    Optional<Inventory> getInventoryById(int id);
    Inventory getInventoryByPid(int pid);
    Inventory createInventory(Inventory inventory);
    void deleteInventoryByPid(int pid);
}
