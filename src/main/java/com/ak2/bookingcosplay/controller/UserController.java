package com.ak2.bookingcosplay.controller;

import com.ak2.bookingcosplay.entity.User;
import com.ak2.bookingcosplay.entity.Admin;
import com.ak2.bookingcosplay.entity.Customer;
import com.ak2.bookingcosplay.dto.UserDTO;
import com.ak2.bookingcosplay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/register")
  // public User register(@RequestBody User user) {
  // String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
  // user.setPassword(hashedPassword);
  // return userRepository.save(user);
  // }
  public User register(@RequestBody UserDTO dto) {
    String hashedPassword = BCrypt.hashpw(dto.password, BCrypt.gensalt());

    User user;
    if ("admin".equalsIgnoreCase(dto.role)) {
      user = new Admin(dto.id, dto.name, dto.email, hashedPassword);
    } else {
      user = new Customer(dto.id, dto.name, dto.email, hashedPassword);
    }

    return userRepository.save(user);
  }

  @PostMapping("/login")
  public String login(@RequestBody LoginRequest loginRequest) {
    Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
    if (userOptional.isPresent()) {
      User user = userOptional.get();
      if (BCrypt.checkpw(loginRequest.getPassword(), user.getPassword())) {
        return "Login berhasil sebagai " + user.getRole();
      } else {
        return "Password salah!";
      }
    } else {
      return "User tidak ditemukan!";
    }
  }

  public static class LoginRequest {
    private String email;
    private String password;

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
  }
}
