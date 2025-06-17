package com.cts.hotel.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hotel.Model.Booking;
import com.cts.hotel.Model.Payment;
import com.cts.hotel.Service.PaymentService;

@RestController
@RequestMapping("/users/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	public ResponseEntity<List<Payment>> getMethodName() {
		List<Payment> booking= paymentService.getPayments();
		return ResponseEntity.ok(booking);
	}
	
	@PostMapping("/pay")
	public ResponseEntity<?> postBooking(@RequestBody Payment payment) {
		//TODO: process POST request
		paymentService.addPayment(payment);
		return ResponseEntity.ok(Collections.singletonMap("message", " Paid successfully"));
	}
	
}
