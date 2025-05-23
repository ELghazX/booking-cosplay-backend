package com.ak2.bookingcosplay.service;

import java.util.List;

import com.ak2.bookingcosplay.dto.RequestCreateBooking;
import com.ak2.bookingcosplay.dto.RequestUpdateBookingStatus;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.dto.ResponseDetailBooking;
import com.ak2.bookingcosplay.dto.ResponsePendingBooking;
import com.ak2.bookingcosplay.entity.Booking;

public interface BookingService {

  ResponseDefault createBooking(RequestCreateBooking request);

  ResponsePendingBooking getBookingByStatus(String status);

  List<Booking> getAllBooking();

  ResponseDefault updateBookingStatus(RequestUpdateBookingStatus request);

  ResponseDetailBooking getBookingDetailById(Long id);

}
