package com.ak2.bookingcosplay.dto;

import java.time.LocalDate;
import java.util.List;

public class ResponsePendingBooking {
  private boolean status;
  private String message;
  List<DataPendingBooking> data;

  public static class DataPendingBooking {
    private Long id;
    private String nameUser;
    private String nameItem;
    private LocalDate startDate;
    private String duration;
    private int totalPrice;
    private String status;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getNameUser() {
      return nameUser;
    }

    public void setNameUser(String nameUser) {
      this.nameUser = nameUser;
    }

    public String getNameItem() {
      return nameItem;
    }

    public void setNameItem(String nameItem) {
      this.nameItem = nameItem;
    }

    public String getDuration() {
      return duration;
    }

    public void setDuration(String duration) {
      this.duration = duration;
    }

    public int getTotalPrice() {
      return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
      this.totalPrice = totalPrice;
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }

    public LocalDate getStartDate() {
      return startDate;
    }

    public void setStartDate(LocalDate startDate) {
      this.startDate = startDate;
    }

  }

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

  public List<DataPendingBooking> getData() {
    return data;
  }

  public void setData(List<DataPendingBooking> data) {
    this.data = data;
  }

}
