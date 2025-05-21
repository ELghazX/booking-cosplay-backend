package com.ak2.bookingcosplay.controller;

import com.ak2.bookingcosplay.entity.Booking;
import com.ak2.bookingcosplay.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

  @Autowired
  private BookingRepository bookingRepository;

  @GetMapping
  public List<Booking> getAllBookings() {
    return bookingRepository.findAll();
  }

  @PostMapping
  public Booking createBooking(@RequestBody Booking booking) {
    return bookingRepository.save(booking);
  }

  @GetMapping("/{id}")
  public Booking getBookingById(@PathVariable Long id) {
    return bookingRepository.findById(id).orElseThrow();
  }
}
