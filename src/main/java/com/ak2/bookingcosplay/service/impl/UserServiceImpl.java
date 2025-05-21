package com.ak2.bookingcosplay.service.impl;

import com.ak2.bookingcosplay.entity.User;
import com.ak2.bookingcosplay.repository.UserRepository;
import com.ak2.bookingcosplay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public String register(User user) {
    if (userRepository.findByEmail(user.getEmail()).isPresent()) {
      return "Email sudah terdaftar";
    }

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    userRepository.save(user);

    return "Registrasi berhasil";
  }

  @Override
  public String login(String email, String password) {
    User user = userRepository.findByEmail(email).orElse(null);

    if (user != null && passwordEncoder.matches(password, user.getPassword())) {
      return "Login berhasil";
    }

    return "Email atau password salah";
  }
}
