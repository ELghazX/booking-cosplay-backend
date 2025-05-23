package com.ak2.bookingcosplay.dto;

import com.ak2.bookingcosplay.entity.Item;

public class ResponseDetailItem {
  private boolean status;
  private String message;
  private Item item;

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
