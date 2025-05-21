package com.ak2.bookingcosplay.entity;

public class Accessories implements Item {
  private Long id;
  private String name;
  private String description;
  private String pricePerDay;
  private String pricePerWeek;
  private String type; // senjata, kepala, perhiasan, pelengkap
  private boolean isFragile;

  public Accessories(Long id, String name, String description, String pricePerDay, String pricePerWeek,
      String type, boolean isFragile) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.pricePerDay = pricePerDay;
    this.pricePerWeek = pricePerWeek;
    this.type = type;
    this.isFragile = isFragile;
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
    return "Aksesoris";
  }

}
