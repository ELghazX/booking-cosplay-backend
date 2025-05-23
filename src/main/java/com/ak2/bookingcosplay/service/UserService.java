package com.ak2.bookingcosplay.service;

import com.ak2.bookingcosplay.dto.ResponseLoginUser;
import com.ak2.bookingcosplay.dto.ResponseRegister;
import com.ak2.bookingcosplay.entity.User;

public interface UserService {
  ResponseRegister register(User user);

  ResponseLoginUser login(String email, String password);
}
