package com.ak2.bookingcosplay.dto;

public class RequestUpdateBooking {
  private Long id;
  private String status;

  public RequestUpdateBooking() {
  }

  public RequestUpdateBooking(Long id, String status) {
    this.id = id;
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
