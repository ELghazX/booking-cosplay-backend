package com.ak2.bookingcosplay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak2.bookingcosplay.dto.RequestCreateBooking;
import com.ak2.bookingcosplay.dto.RequestUpdateBookingStatus;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.dto.ResponseDetailBooking;
import com.ak2.bookingcosplay.dto.ResponsePendingBooking;
import com.ak2.bookingcosplay.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @GetMapping
  public ResponseEntity<ResponsePendingBooking> getAllBookings() {
    return ResponseEntity.ok(bookingService.getAllBooking());

  }

  @GetMapping("/status/{status}")
  public ResponseEntity<ResponsePendingBooking> getBookingByStatus(@PathVariable String status) {
    return ResponseEntity.ok(bookingService.getBookingByStatus(status));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseDetailBooking> getBookingById(@PathVariable Long id) {
    ResponseDetailBooking response = bookingService.getBookingDetailById(id);
    if (!response.isStatus()) {
      return ResponseEntity.badRequest().body(response);
    }
    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<ResponseDefault> createBooking(@RequestBody RequestCreateBooking request) {
    ResponseDefault response = bookingService.createBooking(request);
    if (!response.isStatus()) {
      return ResponseEntity.badRequest().body(response);
    }
    return ResponseEntity.status(201).body(response);
  }

  @PutMapping("/{id}/status")
  public ResponseEntity<ResponseDefault> updateBookingStatus(@PathVariable Long id,
      @RequestBody RequestUpdateBookingStatus request) {
    request.setId(id);
    ResponseDefault response = bookingService.updateBookingStatus(request);
    return ResponseEntity.ok(response);
  }
}
