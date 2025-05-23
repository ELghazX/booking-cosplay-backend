package com.ak2.bookingcosplay.controller;

import com.ak2.bookingcosplay.entity.Booking;
import com.ak2.bookingcosplay.dto.RequestUpdateBooking;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.dto.RequestCreateBooking;
import com.ak2.bookingcosplay.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @GetMapping
  public List<Booking> getAllBookings() {
    return bookingService.getAllBooking();
  }

  @GetMapping("/{id}")
  public Optional<Booking> getBookingById(@PathVariable Long id) {
    return bookingService.getBookingById(id);
  }

  @PostMapping
  public ResponseEntity<ResponseDefault> createBooking(@RequestBody RequestCreateBooking request) {
    ResponseDefault response = bookingService.createBooking(request);
    if (!response.isStatus()) {
      return ResponseEntity.badRequest().body(response);
    }
    return ResponseEntity.status(201).body(response);
  }

  @PutMapping("/{id}")
  public String updateBooking(@PathVariable Long id, @RequestBody RequestUpdateBooking request) {
    request.setId(id);
    return bookingService.updateBooking(request);
  }
}
