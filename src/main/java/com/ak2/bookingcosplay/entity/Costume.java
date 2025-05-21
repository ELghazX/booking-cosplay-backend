package com.ak2.bookingcosplay.entity;

import jakarta.persistence.*;

@Entity
public class Costume extends Item {
  private String characterName;
  private String gender;

  // Constructor
  public Costume() {
  }

  public Costume(Long id, String name, String imageUrl, Integer pricePerDay, String characterName, String gender) {
    super(id, name, imageUrl, pricePerDay);
    this.characterName = characterName;
    this.gender = gender;
  }

  // Getter & Setter
  public String getCharacterName() {
    return characterName;
  }

  public void setCharacterName(String characterName) {
    this.characterName = characterName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}
