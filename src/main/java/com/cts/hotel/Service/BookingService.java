package com.cts.hotel.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.hotel.Model.Booking;
import com.cts.hotel.Repo.BookingRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	@Transactional
	public void addBookings(Booking booking) {
		bookingRepository.save(booking);
	}
	
	public boolean isRoomAvailable(int roomID, Date checkInDate, Date checkOutDate) {
		List<Booking> conflictingBookings = bookingRepository.findConflictingBookings(roomID, checkInDate, checkOutDate);
		return conflictingBookings.isEmpty(); // Room is available if no conflicts exist
	}
	
	 public String bookRoom(Booking newBooking) {
	        boolean available = isRoomAvailable(newBooking.getRoomID(), newBooking.getCheckInDate(), newBooking.getCheckOutDate());
	        
	        if (!available) {
	            return "Room is already booked for these dates. Please choose different dates.";
	        }
	        
	        bookingRepository.save(newBooking);
	        return "Booking successful!";
	    }
}
