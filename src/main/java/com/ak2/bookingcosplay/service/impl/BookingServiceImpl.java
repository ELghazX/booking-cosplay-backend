// package com.ak2.bookingcosplay.service.impl;
//
// import com.ak2.bookingcosplay.entity.Booking;
// import com.ak2.bookingcosplay.entity.Item;
// import com.ak2.bookingcosplay.entity.User;
// import com.ak2.bookingcosplay.exception.BookingNotFoundException;
// import com.ak2.bookingcosplay.repository.BookingRepository;
// import com.ak2.bookingcosplay.repository.ItemRepository;
// import com.ak2.bookingcosplay.repository.UserRepository;
// import com.ak2.bookingcosplay.service.BookingService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
//
// import java.time.LocalDate;
// import java.util.List;
// import java.util.Optional;
//
// @Service
// public class BookingServiceImpl implements BookingService {
//
// @Autowired
// private BookingRepository bookingRepository;
//
// @Autowired
// private ItemRepository itemRepository;
//
// @Autowired
// private UserRepository userRepository;
//
// @Override
// public String createBooking(Long userId, Long itemId, LocalDate startDate,
// Integer duration) {
// Optional<User> user = userRepository.findById(userId);
// Optional<Item> item = itemRepository.findById(itemId);
//
// if (user.isPresent() && item.isPresent()) {
// Booking booking = new Booking();
// booking.setUser(user.get());
// booking.setItem(item.get());
// booking.setStartDate(startDate);
// booking.setDuration(duration);
// booking.setTotalPrice(item.get().getPricePerDay() * duration);
// booking.setStatus(Booking.BookingStatus.PENDING);
// bookingRepository.save(booking);
// return "Booking berhasil dibuat";
// }
// return "Item atau User tidak ditemukan";
// }
//
// @Override
// public List<Booking> getBookingsByUser(Long userId) {
// Optional<User> user = userRepository.findById(userId);
// return user.map(bookingRepository::findByUser)
// .orElseThrow(() -> new BookingNotFoundException("User not found with id: " +
// userId));
// }
//
// @Override
// public String cancelBooking(Long bookingId) {
// Optional<Booking> booking = bookingRepository.findById(bookingId);
// if (booking.isPresent() && booking.get().getStatus() ==
// Booking.BookingStatus.PENDING) {
// booking.get().setStatus(Booking.BookingStatus.CANCELLED);
// bookingRepository.save(booking.get());
// return "Booking berhasil dibatalkan";
// }
// throw new BookingNotFoundException("Booking not found with id: " +
// bookingId);
// }
// }
