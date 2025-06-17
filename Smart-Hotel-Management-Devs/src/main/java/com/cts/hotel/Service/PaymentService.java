package com.cts.hotel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hotel.Model.Booking;
import com.cts.hotel.Model.Payment;
import com.cts.hotel.Repo.BookingRepository;
import com.cts.hotel.Repo.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Payment> getPayments() {
		return paymentRepository.findAll();
	}
	
	@Transactional
	public void addPayment(Payment payment) {
		int id=payment.getBooking();
		paymentRepository.save(payment);
	}
}
