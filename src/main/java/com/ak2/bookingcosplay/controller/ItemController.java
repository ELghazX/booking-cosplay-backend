package com.ak2.bookingcosplay.controller;

import java.io.IOException;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ak2.bookingcosplay.dto.RequestCreateAccessory;
import com.ak2.bookingcosplay.dto.RequestCreateCostume;
import com.ak2.bookingcosplay.dto.ResponseCardItem;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.dto.ResponseDetailItem;
import com.ak2.bookingcosplay.entity.Accessory;
import com.ak2.bookingcosplay.entity.Costume;
import com.ak2.bookingcosplay.service.ItemService;

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

  @PostMapping(value = "/create-costume", consumes = {"multipart/form-data"})
  public ResponseEntity<ResponseDefault> createCostume(
    @RequestParam("name") String name,
    @RequestParam("pricePerDay") int pricePerDay,
    @RequestParam("size") String size,
    @RequestParam("gender") String gender,
    @RequestParam("characterName") String characterName,
    @RequestParam("image") MultipartFile imageFile
  ) throws IOException {
    String uploadDir = "uploads/";
    String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
    File dest = new File(uploadDir + fileName);
    dest.getParentFile().mkdirs();
    imageFile.transferTo(dest);

    Costume costume = new Costume();
    costume.setName(name);
    costume.setImageUrl("/uploads/" + fileName); // Simpan path gambar
    costume.setPricePerDay(pricePerDay);
    costume.setSize(size);
    costume.setGender(gender);
    costume.setCharacterName(characterName);

    ResponseDefault response = itemService.createItem(costume);
    if (!response.isStatus()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(response);
  }

  @PostMapping(value = "/create-accessory", consumes = {"multipart/form-data"})
  public ResponseEntity<ResponseDefault> createAccessory(
    @RequestParam("name") String name,
    @RequestParam("pricePerDay") int pricePerDay,
    @RequestParam("type") String type,
    @RequestParam("image") MultipartFile imageFile
  ) throws IOException {
    String uploadDir = "uploads/";
    String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
    File dest = new File(uploadDir + fileName);
    dest.getParentFile().mkdirs();
    imageFile.transferTo(dest);

    Accessory accessory = new Accessory();
    accessory.setName(name);
    accessory.setImageUrl("/uploads/" + fileName); // Simpan path gambar
    accessory.setPricePerDay(pricePerDay);
    accessory.setType(type);

    ResponseDefault response = itemService.createItem(accessory);
    if (!response.isStatus()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(response);
  }

  @PutMapping(value = "update-accessory/{id}", consumes = {"multipart/form-data"})
  public ResponseEntity<ResponseDefault> updateAccessory(
    @PathVariable Long id,
    @RequestParam("name") String name,
    @RequestParam("pricePerDay") int pricePerDay,
    @RequestParam("type") String type,
    @RequestParam(value = "image", required = false) MultipartFile imageFile
  ) throws IOException {
    Accessory accessory = new Accessory();
    accessory.setName(name);
    accessory.setPricePerDay(pricePerDay);
    accessory.setType(type);

    if (imageFile != null && !imageFile.isEmpty()) {
        String uploadDir = "uploads/";
        String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
        File dest = new File(uploadDir + fileName);
        dest.getParentFile().mkdirs();
        imageFile.transferTo(dest);
        accessory.setImageUrl("/uploads/" + fileName);
    }

    ResponseDefault response = itemService.updateItem(id, accessory);
    if (!response.isStatus()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(response);
  }

  @PutMapping(value = "update-costume/{id}", consumes = {"multipart/form-data"})
  public ResponseEntity<ResponseDefault> updateCostume(
    @PathVariable Long id,
    @RequestParam("name") String name,
    @RequestParam("pricePerDay") int pricePerDay,
    @RequestParam("size") String size,
    @RequestParam("gender") String gender,
    @RequestParam("characterName") String characterName,
    @RequestParam(value = "image", required = false) MultipartFile imageFile
  ) throws IOException {
    Costume costume = new Costume();
    costume.setName(name);
    costume.setPricePerDay(pricePerDay);
    costume.setSize(size);
    costume.setGender(gender);
    costume.setCharacterName(characterName);

    if (imageFile != null && !imageFile.isEmpty()) {
        String uploadDir = "uploads/";
        String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
        File dest = new File(uploadDir + fileName);
        dest.getParentFile().mkdirs();
        imageFile.transferTo(dest);
        costume.setImageUrl("/uploads/" + fileName);
    }

    ResponseDefault response = itemService.updateItem(id, costume);
    if (!response.isStatus()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseDefault> deleteItem(@PathVariable Long id) {
    ResponseDefault response = itemService.deleteItem(id);
    if (response.isStatus() == false) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(response);
  }
}
