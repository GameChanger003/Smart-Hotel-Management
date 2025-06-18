package com.cts.hotel.Controller;

import java.util.Collections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/getPaymentIdByBookingId")
	public ResponseEntity<Integer> getPaymentId(@RequestParam int bookingId) {
		int paymentId = paymentService.getPaymentIdByBookingId(bookingId);
		return ResponseEntity.ok(paymentId);
	}

	@PostMapping("/savePayment")
	public ResponseEntity<String> savePayment(@RequestBody Payment payment) {
	    return paymentService.savePayment(payment);
	}

//	@PostMapping
//	public ResponseEntity<String> savePayment(@RequestBody Payment payment) {
//		return paymentService.savePayment(payment);
//	}

	@GetMapping("/fetchPaymentById")
	public Payment fetchPaymentById(@RequestParam int paymentId) {

		return paymentService.fetchPaymentById(paymentId);
	}

	@DeleteMapping("/deletePaymentById")
	public Payment deletePaymentById(@RequestParam int paymentId) {

		return paymentService.deletePaymentById(paymentId);
	}

	@PutMapping("/updatePaymentById")
	public Payment updatePaymentById(@RequestParam int oldpaymentId, @RequestBody Payment newPayment) {

		return paymentService.updatePaymentById(oldpaymentId, newPayment);

	}

	@CrossOrigin(origins = "*")
	@GetMapping("/fetchAllPayment")
	public List<Payment> fetchAllPayment() {
		return paymentService.fetchAllPayment();
	}

}
