package com.ak2.bookingcosplay.entity;

public class Costume implements Item {
  private Long id;
  private String name;
  private String description;
  private String pricePerDay;
  private String pricePerWeek;
  private String size;
  private String characterName;
  private String gender;

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
