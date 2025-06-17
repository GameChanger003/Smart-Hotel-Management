package com.cts.hotel.Service;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.hotel.Model.*;
import com.cts.hotel.Repo.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getById(int bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking bookRoomIfAvailable(Booking booking) {
        if (booking.getCheckInDate() == null || booking.getCheckOutDate() == null) {
            throw new IllegalArgumentException("Check-in and check-out dates must not be null.");
        }

        List<Booking> conflicts = bookingRepository.findConflictingBookings(
            booking.getRoomId(),
            booking.getCheckInDate(),
            booking.getCheckOutDate()
        );

        if (!conflicts.isEmpty()) {
            throw new IllegalStateException(" Room is already booked for the selected dates.");
        }

        booking.setStatus(BookingStatus.BOOKED);
        return bookingRepository.save(booking);
    }


    public Booking cancelBooking(int bookingId) {
        Booking booking = getById(bookingId);

        if (booking.getCheckOutDate() == null) {
            throw new IllegalArgumentException("Check-out date is missing.");
        }

        LocalDate now = LocalDate.now();
        LocalDate checkOut = booking.getCheckOutDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long hoursUntilCheckout = ChronoUnit.HOURS.between(now.atStartOfDay(), checkOut.atStartOfDay());

        if (hoursUntilCheckout < 24) {
            throw new RuntimeException("Cannot cancel within 24 hours of check-out.");
        }

        booking.setStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);
    }
}
