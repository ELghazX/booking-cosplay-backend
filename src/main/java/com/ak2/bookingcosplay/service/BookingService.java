package com.ak2.bookingcosplay.service;

import com.ak2.bookingcosplay.dto.RequestUpdateBooking;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.dto.ResponseDetailBooking;
import com.ak2.bookingcosplay.dto.ResponsePendingBooking;
import com.ak2.bookingcosplay.dto.RequestCreateBooking;
import com.ak2.bookingcosplay.entity.Booking;

import java.util.List;

public interface BookingService {
  // Booking createBooking(Booking item);

  // String createBooking(Long userId, Long itemId, LocalDate startDate, int
  // duration);
  ResponseDefault createBooking(RequestCreateBooking request);

  ResponsePendingBooking getBookingByStatus(String status);

  List<Booking> getAllBooking();

  ResponseDetailBooking getBookingDetailById(Long id);

  // Booking updateBooking(Long id, Booking item);

  String updateBooking(RequestUpdateBooking request);
  // void deleteBooking(Long id);
}
