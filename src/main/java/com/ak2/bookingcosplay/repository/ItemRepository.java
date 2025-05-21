package com.ak2.bookingcosplay.repository;

import com.ak2.bookingcosplay.entity.Item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
  List<Item> findByDeletedFalse(); // Custom query to get only non-deleted items
}
