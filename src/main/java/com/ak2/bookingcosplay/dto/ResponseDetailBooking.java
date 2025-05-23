package com.ak2.bookingcosplay.dto;

public class ResponseDetailBooking {
  private boolean status;
  private String message;
  private DataDetailBooking data;

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

  public DataDetailBooking getData() {
    return data;
  }

  public void setData(DataDetailBooking data) {
    this.data = data;
  }

  public static class DataDetailBooking {
    private Long id;
    private String nameUser;
    private String itemName;
    private String startDate;
    private int duration;
    private int totalPrice;
    private String status;

    // Getters & Setters
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

    public String getItemName() {
      return itemName;
    }

    public void setItemName(String itemName) {
      this.itemName = itemName;
    }

    public String getStartDate() {
      return startDate;
    }

    public void setStartDate(String startDate) {
      this.startDate = startDate;
    }

    public int getDuration() {
      return duration;
    }

    public void setDuration(int duration) {
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
  }
}
