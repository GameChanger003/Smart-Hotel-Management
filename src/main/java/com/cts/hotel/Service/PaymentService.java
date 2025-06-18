package com.cts.hotel.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.hotel.DAO.PaymentDao;
import com.cts.hotel.Model.Booking;
import com.cts.hotel.Model.Payment;
import com.cts.hotel.Model.PaymentStatus;
import com.cts.hotel.Repo.BookingRepository;
import com.cts.hotel.Repo.PaymentRepository;
import com.cts.hotel.exceptions.PaymentFailedException;

import jakarta.transaction.Transactional;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;

//	public Payment savePayment(Payment payment) {
//
//		return paymentDao.savePayment(payment);
//
//	}
//	
	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private BookingService bookingService;

	public ResponseEntity<String> savePayment(Payment payment) {
		int bookingId = payment.getBookingId();

		// Attempt to retrieve the booking
		ResponseEntity<Booking> response = bookingService.getById(bookingId);
		Booking booking = response.getBody();

		// Validate booking existence or fetch failure
		if (booking == null || response.getStatusCode().is4xxClientError()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid booking ID: " + bookingId);
		}

		if (payment.getStatus() == PaymentStatus.SUCCESS) {
			Payment saved = paymentDao.savePayment(payment);
			booking.setPaymentID(saved.getPaymentId());
			bookingService.saveBooking(booking);

			return ResponseEntity.ok("Saved");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment failed. Status: " + payment.getStatus());
		}
	}

	public int getPaymentIdByBookingId(int bookingId) {
		return paymentRepository.findByBookingId(bookingId).map(Payment::getPaymentId)
				.orElseThrow(() -> new RuntimeException("Payment not found for Booking ID: " + bookingId));
	}

	public Payment fetchPaymentById(int paymentId) {

		return paymentDao.fetchPaymentById(paymentId);
	}

	public Payment deletePaymentById(int paymentId) {

		return paymentDao.deletePaymentById(paymentId);
	}

	public Payment updatePaymentById(int oldpaymentId, Payment newPayment) {

		return paymentDao.updatePaymentById(oldpaymentId, newPayment);

	}

	public List<Payment> fetchAllPayment() {
		return paymentDao.fetchAllPayment();
	}

}
