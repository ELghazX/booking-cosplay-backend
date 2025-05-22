package com.ak2.bookingcosplay.controller;

import com.ak2.bookingcosplay.dto.RequestCreateAccessory;
import com.ak2.bookingcosplay.dto.RequestCreateCostume;
import com.ak2.bookingcosplay.dto.ResponseCardItem;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.entity.Accessory;
import com.ak2.bookingcosplay.entity.Costume;
import com.ak2.bookingcosplay.entity.Item;
import com.ak2.bookingcosplay.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

  @Autowired
  private ItemService itemService;

  @PostMapping("/costume")
  public ResponseEntity<ResponseDefault> createCostume(@RequestBody RequestCreateCostume request) {
    Costume costume = new Costume();
    costume.setName(request.getName());
    costume.setImageUrl(request.getImageUrl());
    costume.setPricePerDay(request.getPricePerDay());
    costume.setSize(request.getSize());
    costume.setGender(request.getGender());
    costume.setCharacterName(request.getCharacterName());
    ResponseDefault response = itemService.createItem(costume);
    if (response.isStatus() == false) {
      return ResponseEntity.badRequest().body(response);
    }
    return ResponseEntity.ok(response);
  }

  @PostMapping("/accessory")
  public ResponseEntity<ResponseDefault> createAccessory(@RequestBody RequestCreateAccessory request) {
    Accessory accessory = new Accessory();
    accessory.setName(request.getName());
    accessory.setImageUrl(request.getImageUrl());
    accessory.setPricePerDay(request.getPricePerDay());
    accessory.setType(request.getType());
    ResponseDefault response = itemService.createItem(accessory);
    if (response.isStatus() == false) {
      return ResponseEntity.badRequest().body(response);
    }
    return ResponseEntity.ok(response);
  }

  @GetMapping
  public List<ResponseCardItem> getAllItems() {
    return itemService.getAllItems();
  }

  @GetMapping("/{id}")
  public Item getItemById(@PathVariable Long id) {
    return itemService.getItemById(id);
  }

  // Update item by ID
  @PutMapping("/{id}")
  public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
    return itemService.updateItem(id, item);
  }

  // Soft delete item by ID
  @DeleteMapping("/{id}")
  public void deleteItem(@PathVariable Long id) {
    itemService.deleteItem(id);
  }
}
