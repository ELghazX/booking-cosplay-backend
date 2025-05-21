package com.ak2.bookingcosplay.repository;

import com.ak2.bookingcosplay.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
  List<Item> findByNameContaining(String name);
}
