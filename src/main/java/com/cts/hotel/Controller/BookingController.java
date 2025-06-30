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

//    @Autowired
//    private PaymentService paymentService;
    
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int bookingId) {
        return bookingService.getById(bookingId); 
    }



    @PostMapping("/book")
    public ResponseEntity<?> bookRoom(@RequestBody Booking booking) {
            return  bookingService.bookRoomIfAvailable(booking);               
        }

    @PutMapping("/cancel/{bookingId}")
    public ResponseEntity<?> cancelBooking(@PathVariable int bookingId) {
        return bookingService.cancelBooking(bookingId);
    }
    
    @PutMapping("/updateBooking")
    public Booking updateBooking(int oldBookingId, Booking newBooking) {
    	return bookingService.updateBooking(oldBookingId, newBooking);
    	
    }
    
}
