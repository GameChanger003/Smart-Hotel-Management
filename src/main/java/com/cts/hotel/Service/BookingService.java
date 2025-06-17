package com.cts.hotel.Service;

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

}
