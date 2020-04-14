package com.exercise.inventories.api;

import com.exercise.inventories.model.Inventories;
import com.exercise.inventories.model.Inventory;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * A delegate to be called by the {@link InventoriesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
public interface InventoriesApiDelegate {

    /**
     * @see InventoriesApi#addInventory
     */
    ResponseEntity<Inventory> addInventory( Inventory  body);

    /**
     * @see InventoriesApi#getAllInventories
     */
    ResponseEntity<Inventories> getAllInventories();

    /**
     * @see InventoriesApi#getInventoryById
     */
    ResponseEntity<Inventory> getInventoryById( Integer  inventoryId);

}
