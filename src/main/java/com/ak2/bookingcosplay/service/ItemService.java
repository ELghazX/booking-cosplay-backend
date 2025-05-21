package com.ak2.bookingcosplay.service;

import com.ak2.bookingcosplay.entity.Item;

import java.util.List;

public interface ItemService {
  Item createItem(Item item);

  List<Item> getAllItems();

  Item getItemById(Long id);

  Item updateItem(Long id, Item item);

  void deleteItem(Long id);
}
