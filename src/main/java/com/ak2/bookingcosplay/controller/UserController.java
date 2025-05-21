package com.ak2.bookingcosplay.controller;

import com.ak2.bookingcosplay.entity.User;
import com.ak2.bookingcosplay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

  @Autowired
  private UserService userService;

  // Register endpoint
  @PostMapping("/register")
  public String register(@RequestBody User user) {
    return userService.register(user);
  }

  // Login endpoint
  @PostMapping("/login")
  public String login(@RequestParam String email, @RequestParam String password) {
    return userService.login(email, password);
  }
}
