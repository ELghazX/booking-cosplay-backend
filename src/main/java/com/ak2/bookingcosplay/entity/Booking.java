package com.ak2.bookingcosplay.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // ID customer yang melakukan booking
  private Long customerId;

  // Ini bisa mengacu ke Costume atau Accessories
  private Long itemId;

  // Nilai bisa "costume" atau "accessories"
  private String itemType;

  private LocalDate startDate;

  // Durasi sewa dalam hari/minggu
  private int duration;

  // "daily" atau "weekly"
  private String rentalType;

  private BigDecimal price;

  // "pending", "confirmed", "cancelled", dll.
  private String status;

  public Booking() {
  }

  public Booking(Long customerId, Long itemId, String itemType, LocalDate startDate, int duration, String rentalType,
      BigDecimal price, String status) {
    this.customerId = customerId;
    this.itemId = itemId;
    this.itemType = itemType;
    this.startDate = startDate;
    this.duration = duration;
    this.rentalType = rentalType;
    this.price = price;
    this.status = status;
  }

  // Getters & Setters

  public Long getId() {
    return id;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public String getItemType() {
    return itemType;
  }

  public void setItemType(String itemType) {
    this.itemType = itemType;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public String getRentalType() {
    return rentalType;
  }

  public void setRentalType(String rentalType) {
    this.rentalType = rentalType;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
