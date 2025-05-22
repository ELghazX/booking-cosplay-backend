package com.ak2.bookingcosplay.service;

import com.ak2.bookingcosplay.entity.User;
import com.ak2.bookingcosplay.dto.ResponseLoginUser;
import com.ak2.bookingcosplay.dto.ResponseRegister;

public interface UserService {
  ResponseRegister register(User user);

  ResponseLoginUser login(String email, String password);
  // String login(String email, String password);
}
