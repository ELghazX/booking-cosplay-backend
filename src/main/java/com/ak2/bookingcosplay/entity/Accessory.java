package com.ak2.bookingcosplay.entity;

import jakarta.persistence.*;

@Entity
public class Accessory extends Item {
  private String type; // "Senjata", "Kepala", "Perhiasan"

  // Constructor
  public Accessory() {
  }

  public Accessory(Long id, String name, String imageUrl, Integer pricePerDay, String type) {
    super(id, name, imageUrl, pricePerDay);
    this.type = type;
  }

  // Getter & Setter
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
