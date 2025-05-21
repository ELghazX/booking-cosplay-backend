package com.ak2.bookingcosplay.controller;

import com.ak2.bookingcosplay.entity.Booking;
import com.ak2.bookingcosplay.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @PostMapping
  public String createBooking(@RequestParam Long userId, @RequestParam Long itemId,
      @RequestParam String startDate, @RequestParam Integer duration) {
    LocalDate date = LocalDate.parse(startDate);
    return bookingService.createBooking(userId, itemId, date, duration);
  }

  @GetMapping
  public List<Booking> getBookings(@RequestParam Long userId) {
    return bookingService.getBookingsByUser(userId);
  }

  @PutMapping("/{id}/cancel")
  public String cancelBooking(@PathVariable Long id) {
    return bookingService.cancelBooking(id);
  }
}
