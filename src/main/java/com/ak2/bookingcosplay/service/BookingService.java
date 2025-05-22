package com.ak2.bookingcosplay.service;

import com.ak2.bookingcosplay.entity.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingService {
  // Booking createBooking(Booking item);

  String createBooking(Long userId, Long itemId, LocalDate startDate, int duration);

  List<Booking> getAllBooking();

  Optional<Booking> getBookingById(Long id);

  Booking updateBooking(Long id, Booking item);

  // void deleteBooking(Long id);
}
