package com.exercise.inventories.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Inventory
 */
@Validated
public class Inventory   {
  @JsonProperty("inventoryId")
  private Integer inventoryId = null;

  @JsonProperty("itemCode")
  private String itemCode = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  @JsonProperty("status")
  private String status = null;

  public Inventory inventoryId(Integer inventoryId) {
    this.inventoryId = inventoryId;
    return this;
  }

  /**
   * Get inventoryId
   * @return inventoryId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(Integer inventoryId) {
    this.inventoryId = inventoryId;
  }

  public Inventory itemCode(String itemCode) {
    this.itemCode = itemCode;
    return this;
  }

  /**
   * Get itemCode
   * @return itemCode
  **/
  @ApiModelProperty(value = "")
  
    public String getItemCode() {
    return itemCode;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  public Inventory quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  **/
  @ApiModelProperty(value = "")
  
    public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Inventory status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  
    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Inventory inventory = (Inventory) o;
    return Objects.equals(this.inventoryId, inventory.inventoryId) &&
        Objects.equals(this.itemCode, inventory.itemCode) &&
        Objects.equals(this.quantity, inventory.quantity) &&
        Objects.equals(this.status, inventory.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inventoryId, itemCode, quantity, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Inventory {\n");
    
    sb.append("    inventoryId: ").append(toIndentedString(inventoryId)).append("\n");
    sb.append("    itemCode: ").append(toIndentedString(itemCode)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
