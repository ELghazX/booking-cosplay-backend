package com.ak2.bookingcosplay.dto;

public class ResponseLoginUser {
  private boolean status;

  private String message;

  private Infokan data;

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Infokan getData() {
    return data;
  }

  public void setData(Infokan data) {
    this.data = data;
  }

  public static class Infokan {

    private Long id;
    private String name;
    private String role;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getRole() {
      return role;
    }

    public void setRole(String role) {
      this.role = role;
    }

  }

}
