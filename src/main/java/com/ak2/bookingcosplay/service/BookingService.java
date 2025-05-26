package com.ak2.bookingcosplay.service;

import com.ak2.bookingcosplay.dto.RequestCreateBooking;
import com.ak2.bookingcosplay.dto.RequestUpdateBookingStatus;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.dto.ResponseDetailBooking;
import com.ak2.bookingcosplay.dto.ResponsePendingBooking;

public interface BookingService {

  ResponseDefault createBooking(RequestCreateBooking request);

  ResponsePendingBooking getBookingByStatus(String status);

  ResponsePendingBooking getAllBooking();

  ResponseDefault updateBookingStatus(RequestUpdateBookingStatus request);

  ResponseDetailBooking getBookingDetailById(Long id);

  ResponsePendingBooking getBookingByUserId(Long userId);

}
