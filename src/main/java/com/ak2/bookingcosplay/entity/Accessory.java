package com.ak2.bookingcosplay.entity;

import jakarta.persistence.Entity;

@Entity
public class Accessory extends Item {

  private String type; // "senjata", "kepala", "perhiasan"

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
