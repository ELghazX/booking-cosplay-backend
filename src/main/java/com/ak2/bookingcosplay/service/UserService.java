package com.ak2.bookingcosplay.service;

import com.ak2.bookingcosplay.entity.User;

public interface UserService {
  String register(User user);

  String login(String email, String password);
}
