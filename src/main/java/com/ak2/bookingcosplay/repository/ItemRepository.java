package com.ak2.bookingcosplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak2.bookingcosplay.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
  List<Item> findByDeletedFalse();
}
