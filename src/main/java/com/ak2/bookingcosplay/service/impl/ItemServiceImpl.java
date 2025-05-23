package com.ak2.bookingcosplay.service.impl;

import com.ak2.bookingcosplay.dto.ResponseCardItem;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.dto.ResponseDetailItem;
import com.ak2.bookingcosplay.dto.ResponseCardItem.DataCardItem;
import com.ak2.bookingcosplay.entity.Accessory;
import com.ak2.bookingcosplay.entity.Costume;
import com.ak2.bookingcosplay.entity.Item;
import com.ak2.bookingcosplay.repository.ItemRepository;
import com.ak2.bookingcosplay.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
  public ResponseCardItem getAllItems() {
    List<Item> itemCard = itemRepository.findByDeletedFalse(); // Ambil data item yang tidak dihapus
    ResponseCardItem response = new ResponseCardItem();

    if (itemCard.isEmpty()) {
      // Jika data kosong
      response.setStatus(false);
      response.setMessage("Item masih Kosong");
      response.setData(null); // Data adalah null jika tidak ada item
      return response; // Kembalikan response langsung
    }

    // Jika ada item, konversi item menjadi list ResponseCardItem
    List<ResponseCardItem.DataCardItem> dataList = itemCard.stream().map(item -> {
      ResponseCardItem.DataCardItem data = new ResponseCardItem.DataCardItem();
      data.setId(item.getId());
      data.setName(item.getName());
      data.setPrice(item.getPricePerDay()); // Atur harga per hari

      // Tentukan kategori berdasarkan jenis item
      if (item instanceof Costume) {
        data.setCategory("Costume");
      } else if (item instanceof Accessory) {
        data.setCategory("Accessory");
      }

      return data;
    }).collect(Collectors.toList()); // Mengumpulkan semua DataCardItem ke dalam list

    // Mengatur response setelah data ada
    response.setStatus(true);
    response.setMessage("Item berhasil dimuat");
    response.setData(dataList); // Set data menjadi list dari DataCardItem

    return response; // Kembalikan response dengan data yang sudah terisi
  }

  @Override
  public ResponseDetailItem getItemById(Long id) {
    try {
      ResponseDetailItem response = new ResponseDetailItem();
      Item item = itemRepository.findById(id).orElse(null);
      if (item == null) {
        response.setStatus(false);
        response.setMessage("Item tidak ditemukan");
        return response;
      }
      response.setStatus(true);
      response.setMessage("Item ditemukan");
      response.setItem(item);
      return response;
    } catch (Exception e) {
      ResponseDetailItem response = new ResponseDetailItem();
      response.setStatus(false);
      response.setMessage("Gagal mendapatkan item: " + e.getMessage());
      return response;
    }
  }

  @Override
  public ResponseDefault updateItem(Long id, Item item) {
    ResponseDefault response = new ResponseDefault();
    try {
      item.setId(id);
      itemRepository.save(item);
      if (item instanceof Costume) {
        response.setStatus(true);
        response.setMessage("Kostum berhasil diperbarui");
        return response;
      } else if (item instanceof Accessory) {
        response.setStatus(true);
        response.setMessage("Aksesoris berhasil diperbarui");
        return response;
      }
    } catch (Exception e) {
      response.setStatus(false);
      response.setMessage("Gagal memperbarui item: " + e.getMessage());
    }

    return response;
  }

  @Override
  public ResponseDefault deleteItem(Long id) {
    ResponseDefault response = new ResponseDefault();
    Item item = itemRepository.findById(id).orElse(null);
    if (item == null) {
      response.setStatus(false);
      response.setMessage("Item tidak ditemukan");

      return response;
    }
    item.setDeleted(true);
    itemRepository.save(item);
    response.setStatus(true);
    response.setMessage("Item berhasil dihapus");
    return response;
  }
}
