package com.ak2.bookingcosplay.dto;

import java.util.List;

public class ResponseCardItem {
  private boolean status;
  private String message;
  List<DataCardItem> data;

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public static class DataCardItem {
    private Long id;
    private String name;
    private int price;
    private String imageUrl;
    private String category;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getPrice() {
      return price;
    }

    public void setPrice(int price) {
      this.price = price;
    }

    public String getCategory() {
      return category;
    }

    public void setCategory(String category) {
      this.category = category;
    }

  }

  public List<DataCardItem> getData() {
    return data;
  }

  public void setData(List<DataCardItem> data) {
    this.data = data;
  }
}
