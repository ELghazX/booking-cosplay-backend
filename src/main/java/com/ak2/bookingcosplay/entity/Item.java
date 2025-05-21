package com.ak2.bookingcosplay.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String imageUrl;
  private Integer pricePerDay;

  // Constructor
  public Item() {
  }

  public Item(Long id, String name, String imageUrl, Integer pricePerDay) {
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.pricePerDay = pricePerDay;
  }

  // Getter & Setter
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

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Integer getPricePerDay() {
    return pricePerDay;
  }

  public void setPricePerDay(Integer pricePerDay) {
    this.pricePerDay = pricePerDay;
  }
}
