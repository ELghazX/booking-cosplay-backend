package com.ak2.bookingcosplay.entity;

public interface Item {
  String getName();

  String getDescription();

  String getPricePerDay();

  String getPricePerWeek();

  String getRentalPrice(boolean weekly);

  String getItemType();
}
