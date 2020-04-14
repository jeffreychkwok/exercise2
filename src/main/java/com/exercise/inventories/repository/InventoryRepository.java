package com.exercise.inventories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exercise.inventories.model.InventoryEntity;;

public interface InventoryRepository extends JpaRepository<InventoryEntity, String> {
	public InventoryEntity findByInventoryId(Integer id);
}
