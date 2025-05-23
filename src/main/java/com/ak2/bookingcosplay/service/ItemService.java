package com.ak2.bookingcosplay.service;

import com.ak2.bookingcosplay.dto.ResponseCardItem;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.dto.ResponseDetailItem;
import com.ak2.bookingcosplay.entity.Item;

public interface ItemService {
  ResponseDefault createItem(Item item);

  ResponseCardItem getAllItems();

  ResponseDetailItem getItemById(Long id);

  ResponseDefault updateItem(Long id, Item Item);

  ResponseDefault deleteItem(Long id);
}
