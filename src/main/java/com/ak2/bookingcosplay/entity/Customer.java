package com.ak2.bookingcosplay.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends User {

  public Customer() {
  }

  public Customer(int id, String name, String email, String password) {
    super(id, name, email, password);
  }

  @Override
  public String getRole() {
    return "Pelanggan";
  }
}
