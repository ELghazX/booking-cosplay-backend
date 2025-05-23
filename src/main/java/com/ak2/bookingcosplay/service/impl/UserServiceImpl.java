package com.ak2.bookingcosplay.service.impl;

import com.ak2.bookingcosplay.entity.User;
import com.ak2.bookingcosplay.dto.ResponseLoginUser;
import com.ak2.bookingcosplay.dto.ResponseRegister;
import com.ak2.bookingcosplay.dto.ResponseLoginUser.Infokan;
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
  public ResponseRegister register(User user) {
    try {
      ResponseRegister response = new ResponseRegister();
      if (userRepository.findByEmail(user.getEmail()).isPresent()) {
        response.setStatus(false);
        response.setMessage("Email sudah terdaftar");
        return response;
      }

      user.setPassword(passwordEncoder.encode(user.getPassword()));

      userRepository.save(user);

      response.setStatus(true);
      response.setMessage("Registrasi berhasil");
      return response;
    } catch (Exception e) {
      ResponseRegister response = new ResponseRegister();
      response.setStatus(false);
      response.setMessage("Registrasi gagal: " + e.getMessage());
      return response;
    }
  }

  @Override
  public ResponseLoginUser login(String email, String password) {
    ResponseLoginUser response = new ResponseLoginUser();
    try {
      User user = userRepository.findByEmail(email).orElse(null);
      if (user == null) {
        response.setStatus(false);
        response.setMessage("User tidak ditemukan");
        return response;
      }
      if (!passwordEncoder.matches(password, user.getPassword())) {
        response.setStatus(false);
        response.setMessage("Password salah");
        return response;
      }
      Infokan data = new Infokan();
      data.setId(user.getId());
      data.setName(user.getName());
      data.setRole(user.getRole());
      response.setStatus(true);
      response.setMessage("Login Berhasil");
      response.setData(data);
    } catch (Exception e) {
      response.setStatus(false);
      response.setMessage("Login gagal: " + e.getMessage());
    }
    return response;
  }
}
