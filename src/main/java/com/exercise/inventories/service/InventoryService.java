package com.exercise.inventories.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.inventories.model.InventoryEntity;
import com.exercise.inventories.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;
	
	public List<InventoryEntity> getAllInventories() {
		List<InventoryEntity> inventories = inventoryRepository.findAll();
		return inventories;
	}
	
	public InventoryEntity addInventory(InventoryEntity inventory) {
		return inventoryRepository.save(inventory);
	}
	
	public InventoryEntity findByInventoryId(Integer id) {
		return inventoryRepository.findByInventoryId(id);
	}
}
