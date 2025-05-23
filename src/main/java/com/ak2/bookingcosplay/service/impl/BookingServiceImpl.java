package com.ak2.bookingcosplay.service.impl;

import com.ak2.bookingcosplay.dto.RequestUpdateBooking;
import com.ak2.bookingcosplay.dto.ResponseDefault;
import com.ak2.bookingcosplay.dto.ResponseDetailBooking;
import com.ak2.bookingcosplay.dto.ResponsePendingBooking;
import com.ak2.bookingcosplay.dto.ResponsePendingBooking.DataPendingBooking;
import com.ak2.bookingcosplay.dto.RequestCreateBooking;
import com.ak2.bookingcosplay.entity.Booking;
import com.ak2.bookingcosplay.entity.User;
import com.ak2.bookingcosplay.entity.Item;
import com.ak2.bookingcosplay.repository.BookingRepository;
import com.ak2.bookingcosplay.repository.UserRepository;
import com.ak2.bookingcosplay.repository.ItemRepository;
import com.ak2.bookingcosplay.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public ResponseDefault createBooking(RequestCreateBooking request) {
    ResponseDefault response = new ResponseDefault();

    try {
      Booking booking = new Booking();

      Optional<User> userOpt = userRepository.findById(request.getUserId());
      if (userOpt.isPresent()) {
        booking.setUser(userOpt.get());
      } else {
        response.setStatus(false);
        response.setMessage("Id user tidak ditemukan");
        return response;
      }

      Optional<Item> itemOpt = itemRepository.findById(request.getItemId());
      if (itemOpt.isPresent()) {
        booking.setItem(itemOpt.get());
      } else {
        response.setStatus(false);
        response.setMessage("Id item tidak ditemukan");
        return response;
      }

      booking.setStartDate(request.getStartDate());
      booking.setDuration(request.getDuration());
      booking.setStatus("PENDING");

      bookingRepository.save(booking);

      response.setStatus(true);
      response.setMessage("Booking berhasil");
      return response;

    } catch (Exception e) {
      response.setStatus(false);
      response.setMessage("Booking gagal: " + e.getMessage());
      return response;
    }
  }

  // @Override
  // public String createBooking(Long userId, Long itemId, LocalDate startDate,
  // int duration) {
  //
  // Booking booking = new Booking();
  // Optional<User> userOpt = userRepository.findById(userId);
  // if (userOpt.isPresent()) {
  // User user = userOpt.get();
  // booking.setUser(userOpt.get());
  // } else {
  // return "Id user tidak ditemukan";
  // }
  // Optional<Item> itemOpt = itemRepository.findById(itemId);
  //
  // if (itemOpt.isPresent()) {
  // Item item = itemOpt.get();
  // booking.setItem(item);
  // } else {
  // return "Id Item tidak ditemukan";
  // }
  // booking.setStartDate(startDate);
  // booking.setDuration(duration);
  // booking.setStatus("PENDING");
  //
  // bookingRepository.save(booking);
  // return "booking berhasil";
  // }

  @Override
  public List<Booking> getAllBooking() {
    return bookingRepository.findAll();
  }

  @Override
  public ResponsePendingBooking getBookingByStatus(String status) {
    List<Booking> bookings = bookingRepository.findByStatus(status.toUpperCase());

    List<ResponsePendingBooking.DataPendingBooking> dataList = bookings.stream().map(booking -> {
      DataPendingBooking data = new ResponsePendingBooking.DataPendingBooking();
      data.setId(booking.getId());
      data.setNameUser(booking.getUser().getName());
      data.setNameItem(booking.getItem().getName());
      data.setStartDate(booking.getStartDate().toString());
      data.setDuration(booking.getDuration() + " hari");

      int total = booking.getItem().getPricePerDay() * booking.getDuration();
      data.setTotalPrice(total);
      data.setStatus(booking.getStatus());
      return data;
    }).toList();

    ResponsePendingBooking response = new ResponsePendingBooking();
    response.setStatus(true);
    response.setMessage("Data booking dengan status " + status);
    response.setData(dataList);
    return response;
  }

  public ResponseDetailBooking getBookingDetailById(Long id) {
    ResponseDetailBooking response = new ResponseDetailBooking();
    Optional<Booking> opt = bookingRepository.findById(id);
    if (opt.isEmpty()) {
      response.setStatus(false);
      response.setMessage("Id booking tidak ditemukan");
      return response;
    }
    Booking booking = opt.get();
    var data = new ResponseDetailBooking.DataDetailBooking();
    data.setId(booking.getId());
    data.setNameUser(booking.getUser().getName());
    data.setItemName(booking.getItem().getName());
    data.setStartDate(booking.getStartDate().toString());
    data.setDuration(booking.getDuration());
    data.setTotalPrice(booking.getItem().getPricePerDay() * booking.getDuration());
    data.setStatus(booking.getStatus());

    response.setStatus(true);
    response.setMessage("Detail booking ditemukan");
    response.setData(data);
    return response;
  }

  @Override
  public String updateBooking(RequestUpdateBooking request) {
    Booking bookingOpt = bookingRepository.findById(request.getId()).orElse(null);
    if (bookingOpt != null) {
      bookingOpt.setStatus(request.getStatus());
      bookingRepository.save(bookingOpt);
      return "Update booking berhasil";
    } else {
      return "Id booking tidak ditemukan";
    }

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
