package com.ak2.bookingcosplay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak2.bookingcosplay.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
