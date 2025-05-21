package com.ak2.bookingcosplay.entity;

import jakarta.persistence.*;

@Entity
public class Costume implements Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private String pricePerDay;
  private String size;
  private String pricePerWeek;
  private String characterName;
  private String gender;
  private String imageUrl;

  public Costume() {
  };

  public Costume(Long id, String name, String description, String pricePerDay, String pricePerWeek,
      String size, String characterName, String gender) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.pricePerDay = pricePerDay;
    this.pricePerWeek = pricePerWeek;
    this.size = size;
    this.characterName = characterName;
    this.gender = gender;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String getPricePerDay() {
    return pricePerDay;
  }

  @Override
  public String getPricePerWeek() {
    return pricePerWeek;
  }

  @Override
  public String getRentalPrice(boolean weekly) {
    return weekly ? pricePerWeek : pricePerDay;
  }

  @Override
  public String getItemType() {
    return "Kostum";
  }
}
