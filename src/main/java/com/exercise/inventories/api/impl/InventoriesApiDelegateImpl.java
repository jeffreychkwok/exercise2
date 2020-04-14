package com.exercise.inventories.api.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.exercise.inventories.api.InventoriesApiDelegate;
import com.exercise.inventories.model.Inventories;
import com.exercise.inventories.model.Inventory;
import com.exercise.inventories.model.InventoryEntity;
import com.exercise.inventories.service.InventoryService;

public class InventoriesApiDelegateImpl implements InventoriesApiDelegate {
	@Autowired
	InventoryService inventoryService;

	@Override
	public ResponseEntity<Inventory> addInventory(Inventory body) {
		InventoryEntity inventoryEntity = convertFrom(body);
		inventoryEntity.setStatus("INITIAL");
		inventoryEntity = inventoryService.addInventory(inventoryEntity);
		Inventory inventory = convertFrom(inventoryEntity);
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Inventories> getAllInventories() {
		List<InventoryEntity> listInventoryEntity = inventoryService.getAllInventories();
		Inventories inventories = new Inventories();
		for (InventoryEntity ie : listInventoryEntity) {
			Inventory inventory = convertFrom(ie);
			inventories.addDataItem(inventory);
		}
		return new ResponseEntity<>(inventories, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Inventory> getInventoryById(Integer inventoryId) {
		InventoryEntity ie = inventoryService.findByInventoryId(inventoryId);
		Inventory inventory = convertFrom(ie);
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}

	private InventoryEntity convertFrom(Inventory inventory) {
		InventoryEntity inventoryEntity = new InventoryEntity();
		inventoryEntity.setInventoryId(inventory.getInventoryId());
		inventoryEntity.setItemCode(inventory.getItemCode());
		inventoryEntity.setQuantity(inventory.getQuantity());
		inventoryEntity.setStatus(inventory.getStatus());
		return inventoryEntity;
	}

	private Inventory convertFrom(InventoryEntity inventoryEntity) {
		Inventory inventory = new Inventory();
		inventory.setInventoryId(inventoryEntity.getInventoryId());
		inventory.setItemCode(inventoryEntity.getItemCode());
		inventory.setQuantity(inventoryEntity.getQuantity());
		inventory.setStatus(inventoryEntity.getStatus());
		return inventory;
	}
}
