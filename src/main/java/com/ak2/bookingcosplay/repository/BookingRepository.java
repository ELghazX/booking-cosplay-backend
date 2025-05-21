package com.ak2.bookingcosplay.repository;

import com.ak2.bookingcosplay.entity.Booking;
import com.ak2.bookingcosplay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
  List<Booking> findByUser(User user);

  List<Booking> findByStatus(Booking.BookingStatus status);
}
