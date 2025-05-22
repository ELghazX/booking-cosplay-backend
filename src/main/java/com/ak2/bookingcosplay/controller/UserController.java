package com.ak2.bookingcosplay.controller;

import com.ak2.bookingcosplay.entity.User;
import com.ak2.bookingcosplay.service.UserService;
import com.ak2.bookingcosplay.dto.RequestLoginUser;
import com.ak2.bookingcosplay.dto.ResponseLoginUser;
import com.ak2.bookingcosplay.dto.ResponseRegister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

  @Autowired
  private UserService userService;

  // Register endpoint
  @PostMapping("/register")
  public ResponseEntity<ResponseRegister> register(@RequestBody User user) {
    ResponseRegister response = userService.register(user);
    if (!response.isStatus()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  // Login endpoint
  @PostMapping("/login")
  public ResponseEntity<ResponseLoginUser> login(@RequestBody RequestLoginUser request) {
    ResponseLoginUser response = userService.login(request.getEmail(), request.getPassword());
    if (!response.isStatus()) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    return ResponseEntity.ok(response);
  }

}
