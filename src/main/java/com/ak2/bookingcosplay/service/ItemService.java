package com.ak2.bookingcosplay.service;

import com.ak2.bookingcosplay.entity.Item;
import java.util.List;

public interface ItemService {
  List<Item> getItemsByName(String name);

  List<Item> getItemsByType(String type);
}
