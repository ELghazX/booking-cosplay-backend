package com.ak2.bookingcosplay.controller;

import com.ak2.bookingcosplay.dto.RequestCreateAccessory;
import com.ak2.bookingcosplay.dto.RequestCreateCostume;
import com.ak2.bookingcosplay.dto.ResponseCardItem;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.dto.ResponseDetailItem;
import com.ak2.bookingcosplay.entity.Accessory;
import com.ak2.bookingcosplay.entity.Costume;
import com.ak2.bookingcosplay.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

  @Autowired
  private ItemService itemService;

  @GetMapping
  public ResponseEntity<ResponseCardItem> getAllItems() {
    ResponseCardItem response = itemService.getAllItems();
    if (response.isStatus() == false) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseDetailItem> getItemById(@PathVariable Long id) {
    ResponseDetailItem response = itemService.getItemById(id);
    if (response.isStatus() == false) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(response);
  }

  @PostMapping("/create-costume")
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
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(response);
  }

  @PostMapping("/create-accessory")
  public ResponseEntity<ResponseDefault> createAccessory(@RequestBody RequestCreateAccessory request) {
    Accessory accessory = new Accessory();
    accessory.setName(request.getName());
    accessory.setImageUrl(request.getImageUrl());
    accessory.setPricePerDay(request.getPricePerDay());
    accessory.setType(request.getType());
    ResponseDefault response = itemService.createItem(accessory);
    if (response.isStatus() == false) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(response);
  }

  @PutMapping("update-accessory/{id}")
  public ResponseEntity<ResponseDefault> updateAccessory(@PathVariable Long id,
      @RequestBody RequestCreateAccessory request) {
    Accessory accessory = new Accessory();
    accessory.setName(request.getName());
    accessory.setImageUrl(request.getImageUrl());
    accessory.setPricePerDay(request.getPricePerDay());
    accessory.setType(request.getType());
    ResponseDefault response = itemService.updateItem(id, accessory);
    if (response.isStatus() == false) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(response);
  }

  @PutMapping("update-costume/{id}")
  public ResponseEntity<ResponseDefault> updateCostume(@PathVariable Long id,
      @RequestBody RequestCreateCostume request) {
    Costume costume = new Costume();
    costume.setName(request.getName());
    costume.setImageUrl(request.getImageUrl());
    costume.setPricePerDay(request.getPricePerDay());
    costume.setSize(request.getSize());
    costume.setGender(request.getGender());
    costume.setCharacterName(request.getCharacterName());
    ResponseDefault response = itemService.updateItem(id, costume);
    if (response.isStatus() == false) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(response);
  }

  // Soft delete item by ID
  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseDefault> deleteItem(@PathVariable Long id) {
    ResponseDefault response = itemService.deleteItem(id);
    if (response.isStatus() == false) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(response);
  }
}
