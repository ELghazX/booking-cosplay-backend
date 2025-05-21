package com.ak2.bookingcosplay.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

  public Admin() {
  }

  public Admin(int id, String name, String email, String password) {
    super(id, name, email, password);
  }

  @Override
  public String getRole() {
    return "Admin";
  }
}
