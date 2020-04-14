package com.exercise.inventories.api;

import com.exercise.inventories.model.Inventories;
import com.exercise.inventories.model.Inventory;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
@Controller
public class InventoriesApiController implements InventoriesApi {

    private final InventoriesApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public InventoriesApiController(InventoriesApiDelegate delegate) {
        this.delegate = delegate;
    }
    public ResponseEntity<Inventory> addInventory(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Inventory body
) {
        return delegate.addInventory(body);
    }

    public ResponseEntity<Inventories> getAllInventories() {
        return delegate.getAllInventories();
    }

    public ResponseEntity<Inventory> getInventoryById(@ApiParam(value = "inventory ID",required=true) @PathVariable("inventoryId") Integer inventoryId
) {
        return delegate.getInventoryById(inventoryId);
    }

}
