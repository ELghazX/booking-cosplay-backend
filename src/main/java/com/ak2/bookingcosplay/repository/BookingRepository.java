package com.ak2.bookingcosplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak2.bookingcosplay.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

  List<Booking> findByStatus(String status);

  List<Booking> findByUserId(Long userId);
}
