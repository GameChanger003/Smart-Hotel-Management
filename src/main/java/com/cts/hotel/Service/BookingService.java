package com.cts.hotel.Service;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cts.hotel.Model.*;
import com.cts.hotel.Repo.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    
    
    public Booking saveBooking(Booking booking) {
    	return bookingRepository.save(booking);
    	
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public ResponseEntity<Booking> getById(int bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);

        if (optionalBooking.isPresent()) {
            return ResponseEntity.ok(optionalBooking.get());
        } else {
            return ResponseEntity.status(422).body(null);
        }
    }


    public ResponseEntity<?> bookRoomIfAvailable(Booking booking) {
        if (booking.getCheckInDate() == null || booking.getCheckOutDate() == null ) {
        	return ResponseEntity.status(400).body("Check-in and check-out dates must not be null");
        }
        
        if (booking.getCheckInDate().after(booking.getCheckOutDate()) && booking.getCheckOutDate().before(booking.getCheckInDate())) {
        	return ResponseEntity.status(400).body("Check-in and check-out dates must be given correctly");
        }

        List<Booking> conflicts = bookingRepository.findConflictingBookings(
            booking.getRoomId(),
            booking.getCheckInDate(),
            booking.getCheckOutDate()
        );

        if (!conflicts.isEmpty()) {
        	return ResponseEntity.status(409).body("Room is already booked for the selected dates.");
        }

        booking.setStatus(BookingStatus.BOOKED);
        return ResponseEntity.ok(bookingRepository.save(booking));
    }


    public ResponseEntity<?> cancelBooking(int bookingId) {
        Booking booking = getById(bookingId).getBody();

//        if (booking.getCheckOutDate() == null) {
//        	return ResponseEntity.status(409).body("Room is already booked for the selected dates.");
//        }

        LocalDate now = LocalDate.now();
        LocalDate checkOut = booking.getCheckOutDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long hoursUntilCheckout = ChronoUnit.HOURS.between(now.atStartOfDay(), checkOut.atStartOfDay());

        if (hoursUntilCheckout < 24) {
        	return ResponseEntity.status(409).body("Cannot cancel within 24 hours of check-out.");

        }

        booking.setStatus(BookingStatus.CANCELLED);
        return ResponseEntity.ok(bookingRepository.save(booking));
    }
    
    public Booking updateBooking(int oldBookingId, Booking newBooking) {
    	newBooking.setBookingID(oldBookingId);
    	return saveBooking(newBooking);
    }
    
}
