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
  public Item createItem(Item item) {
    return itemRepository.save(item);
  }

  @Override
  public List<Item> getAllItems() {
    return itemRepository.findByDeletedFalse(); // Only get non-deleted items
  }

  @Override
  public Item getItemById(Long id) {
    return itemRepository.findById(id).filter(item -> !item.isDeleted()).orElse(null); // Ensure the item is not deleted
  }

  @Override
  public Item updateItem(Long id, Item item) {
    item.setId(id);
    return itemRepository.save(item);
  }

  @Override
  public void deleteItem(Long id) {
    // Instead of actually deleting, mark the item as deleted
    Item item = itemRepository.findById(id).orElse(null);
    if (item != null) {
      item.setDeleted(true);
      itemRepository.save(item); // Update the item to set deleted flag to true
    }
  }
}
