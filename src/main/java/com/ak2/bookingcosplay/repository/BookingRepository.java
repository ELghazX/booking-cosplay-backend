package com.ak2.bookingcosplay.repository;

import com.ak2.bookingcosplay.entity.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
