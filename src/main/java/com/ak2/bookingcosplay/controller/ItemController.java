package com.ak2.bookingcosplay.controller;

import com.ak2.bookingcosplay.entity.Item;
import com.ak2.bookingcosplay.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

  @Autowired
  private ItemService itemService;

  @PostMapping
  public Item createItem(@RequestBody Item item) {
    return itemService.createItem(item);
  }

  @GetMapping
  public List<Item> getAllItems() {
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
