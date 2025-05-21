package com.ak2.bookingcosplay.entity;

import jakarta.persistence.Entity;

@Entity
public class Costume extends Item {

  private String size; // S, M, L, XL
  private String characterName;
  private String gender; // Male, Female, etc.

  // Getters and Setters
  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

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
