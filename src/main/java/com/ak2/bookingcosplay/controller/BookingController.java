package com.ak2.bookingcosplay.controller;

import com.ak2.bookingcosplay.entity.Booking;
import com.ak2.bookingcosplay.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
  public String createBooking(@RequestParam Long userId, Long itemId, LocalDate startDate, int duration) {
    return bookingService.createBooking(userId, itemId, startDate, duration);
  }
}
