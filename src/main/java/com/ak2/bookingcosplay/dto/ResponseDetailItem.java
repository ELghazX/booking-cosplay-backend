package com.ak2.bookingcosplay.dto;

import com.ak2.bookingcosplay.entity.Item;

public class ResponseDetailItem {
  private boolean status;
  private String message;
  private Item data;

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

  public Item getData() {
    return data;
  }

  public void setData(Item data) {
    this.data = data;
  }

}
