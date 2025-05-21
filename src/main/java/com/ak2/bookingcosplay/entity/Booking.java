package com.ak2.bookingcosplay.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "item_id")
  private Item item;

  private LocalDate startDate;
  private Integer duration;
  private Integer totalPrice;

  @Enumerated(EnumType.STRING)
  private BookingStatus status;

  public enum BookingStatus {
    PENDING, CONFIRMED, CANCELLED
  }

  // Constructor
  public Booking() {
  }

  public Booking(Long id, User user, Item item, LocalDate startDate, Integer duration, Integer totalPrice,
      BookingStatus status) {
    this.id = id;
    this.user = user;
    this.item = item;
    this.startDate = startDate;
    this.duration = duration;
    this.totalPrice = totalPrice;
    this.status = status;
  }

  // Getter & Setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Integer getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Integer totalPrice) {
    this.totalPrice = totalPrice;
  }

  public BookingStatus getStatus() {
    return status;
  }

  public void setStatus(BookingStatus status) {
    this.status = status;
  }
}
