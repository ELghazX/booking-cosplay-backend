package com.ak2.bookingcosplay.service.impl;

import com.ak2.bookingcosplay.entity.Item;
import com.ak2.bookingcosplay.repository.ItemRepository;
import com.ak2.bookingcosplay.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  private ItemRepository itemRepository;

  @Override
  public List<Item> getItemsByName(String name) {
    return itemRepository.findByNameContaining(name);
  }

  @Override
  public List<Item> getItemsByType(String type) {
    if ("costume".equalsIgnoreCase(type)) {
      // Find all costumes
      return itemRepository.findByNameContaining("costume");
    } else if ("accessory".equalsIgnoreCase(type)) {
      // Find all accessories
      return itemRepository.findByNameContaining("accessory");
    } else {
      return itemRepository.findAll();
    }
  }
}
