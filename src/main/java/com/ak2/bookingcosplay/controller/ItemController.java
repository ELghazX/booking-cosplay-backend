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

  @GetMapping
  public List<Item> getItems(@RequestParam(required = false) String type, @RequestParam(required = false) String name) {
    if (type != null) {
      return itemService.getItemsByType(type);
    }
    if (name != null) {
      return itemService.getItemsByName(name);
    }
    return itemService.getItemsByType(""); // Return all items if no filter provided
  }

  @GetMapping("/{id}")
  public Item getItemById(@PathVariable Long id) {
    return itemService.getItemsByType("all").stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
  }
}
