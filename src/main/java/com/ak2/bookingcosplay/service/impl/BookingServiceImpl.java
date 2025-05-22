package com.ak2.bookingcosplay.service.impl;

import com.ak2.bookingcosplay.entity.Booking;
import com.ak2.bookingcosplay.entity.User;
import com.ak2.bookingcosplay.entity.Item;
import com.ak2.bookingcosplay.repository.BookingRepository;
import com.ak2.bookingcosplay.repository.UserRepository;
import com.ak2.bookingcosplay.repository.ItemRepository;
import com.ak2.bookingcosplay.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.foreign.Linker.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

  @Autowired
  private BookingRepository bookingRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ItemRepository itemRepository;

  @Override
  public String createBooking(Long userId, Long itemId, LocalDate startDate, int duration) {

    Booking booking = new Booking();
    Optional<User> userOpt = userRepository.findById(userId);
    if (userOpt.isPresent()) {
      User user = userOpt.get();
      booking.setUser(userOpt.get());
    } else {
      return "Id user tidak ditemukan";
    }
    Optional<Item> itemOpt = itemRepository.findById(itemId);

    if (itemOpt.isPresent()) {
      Item item = itemOpt.get();
      booking.setItem(item);
    } else {
      return "Id Item tidak ditemukan";
    }
    booking.setStartDate(startDate);
    booking.setDuration(duration);
    booking.setStatus("PENDING");

    bookingRepository.save(booking);
    return "booking berhasil";
  }

  @Override
  public List<Booking> getAllBooking() {
    return bookingRepository.findAll();
  }

  @Override
  public Optional<Booking> getBookingById(Long id) {
    return bookingRepository.findById(id);
  }

  @Override
  public Booking updateBooking(Long id, Booking item) {
    item.setId(id);
    return bookingRepository.save(item);
  }

  // @Override
  // public void deleteBooking(Long id) {
  // Booking item = BookingRepository.findById(id).orElse(null);
  // if (item != null) {
  // item.setDeleted(true);
  // BookingRepository.save(item);
  // }
  // }
}
