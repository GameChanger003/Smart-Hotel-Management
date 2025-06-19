package com.cts.hotel.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.cts.hotel.Model.Booking;
import com.cts.hotel.Model.Payment;
import com.cts.hotel.Service.BookingService;
import com.cts.hotel.Service.PaymentService;

@RestController
@RequestMapping("/users/booking")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private PaymentService paymentService;
    
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int bookingId) {
        return bookingService.getById(bookingId); // no need to wrap again!
    }



    @PostMapping("/book")
    public ResponseEntity<?> bookRoom(@RequestBody Booking booking,Payment payment) {
        try {
            Booking confirmed = bookingService.bookRoomIfAvailable(booking);            
            return ResponseEntity.ok(confirmed);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @PutMapping("/cancel/{bookingId}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable int bookingId) {
        return ResponseEntity.ok(bookingService.cancelBooking(bookingId));
    }
    
    @PutMapping("/updateBooking")
    public Booking updateBooking(int oldBookingId, Booking newBooking) {
    	return bookingService.updateBooking(oldBookingId, newBooking);
    	
    }
    
}
