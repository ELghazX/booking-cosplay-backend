package com.ak2.bookingcosplay.service;

import com.ak2.bookingcosplay.entity.Booking;
import java.time.LocalDate;
import java.util.List;

public interface BookingService {
  String createBooking(Long userId, Long itemId, LocalDate startDate, Integer duration);

  List<Booking> getBookingsByUser(Long userId);

  String cancelBooking(Long bookingId);
}
