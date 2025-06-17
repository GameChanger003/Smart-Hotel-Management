package com.cts.hotel.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hotel.Model.Booking;
import com.cts.hotel.Service.BookingService;

@RestController
@RequestMapping("/users/booking")
@CrossOrigin(origins = "*")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping
	public ResponseEntity<List<Booking>> getMethodName() {
		List<Booking> booking= bookingService.getAllBookings();
		return ResponseEntity.ok(booking);
	}
	
	@PostMapping("/book")
    public ResponseEntity<String> bookRoom(@RequestBody Booking newBooking) {
        String result = bookingService.bookRoom(newBooking);
        
        if (result.contains("already booked")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        
        return ResponseEntity.ok(result);
    }
	
	
}
