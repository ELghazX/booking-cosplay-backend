package com.ak2.bookingcosplay.service.impl;

import com.ak2.bookingcosplay.dto.ResponseCardItem;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.entity.Accessory;
import com.ak2.bookingcosplay.entity.Costume;
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
  public ResponseDefault createItem(Item item) {
    try {
      itemRepository.save(item);
      ResponseDefault response = new ResponseDefault();
      response.setStatus(true);
      if (item instanceof Costume) {
        response.setMessage("Kostum berhasil ditambahkan");
      } else if (item instanceof Accessory) {
        response.setMessage("Aksesoris berhasil ditambahkan");
      }
      return response;
    } catch (Exception e) {
      ResponseDefault response = new ResponseDefault();
      response.setStatus(false);
      response.setMessage("Gagal menambahkan item: " + e.getMessage());
      return response;
    }
  }

  @Override
  public List<ResponseCardItem> getAllItems() {
    List<Item> itemCard = itemRepository.findByDeletedFalse();
    return itemCard.stream().map(item -> {
      ResponseCardItem response = new ResponseCardItem();
      response.setId(item.getId());
      response.setName(item.getName());
      response.setPrice(item.getPricePerDay());
      if (item instanceof Costume) {
        response.setCategory("Costume");
      } else if (item instanceof Accessory) {
        response.setCategory("Accessory");
      }
      return response;
    }).toList();

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
