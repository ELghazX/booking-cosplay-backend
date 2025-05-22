package com.ak2.bookingcosplay.service;

import com.ak2.bookingcosplay.dto.ResponseCardItem;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.entity.Item;

import java.util.List;

public interface ItemService {
  ResponseDefault createItem(Item item);

  List<ResponseCardItem> getAllItems();

  Item getItemById(Long id);

  Item updateItem(Long id, Item item);

  void deleteItem(Long id);
}
