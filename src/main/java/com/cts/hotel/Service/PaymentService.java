//package com.cts.hotel.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.cts.hotel.DAO.PaymentDao;
//import com.cts.hotel.Model.Booking;
//import com.cts.hotel.Model.Loyality;
//import com.cts.hotel.Model.Payment;
//import com.cts.hotel.Model.PaymentStatus;
//import com.cts.hotel.Repo.BookingRepository;
//import com.cts.hotel.Repo.PaymentRepository;
//import com.cts.hotel.exceptions.PaymentFailedException;
//
//import jakarta.transaction.Transactional;
//
//@Service
//public class PaymentService {
//
//	@Autowired
//	private PaymentDao paymentDao;
//
//	
//	@Autowired
//	private PaymentRepository paymentRepository;
//
//	@Autowired
//	private BookingService bookingService;
//	
//	@Autowired 
//	private LoyaltyAccountService loyaltyAccountService;
//
//	public ResponseEntity<String> savePayment(Payment payment) {
//		int bookingId = payment.getBookingId();
//		System.out.println(payment);
//		// Attempt to retrieve the booking
//		ResponseEntity<Booking> response = bookingService.getById(bookingId);
//		Booking booking = response.getBody();
//		System.out.println(booking);
//
//		// Validate booking existence or fetch failure
//		if (booking == null || response.getStatusCode().is4xxClientError()) {
//			return ResponseEntity.status(400).body("Invalid booking ID: " + bookingId);
//		}
//
//		if (payment.getStatus() == PaymentStatus.SUCCESS) {
//			System.out.println(payment.getAmount());
//			Payment saved = paymentDao.savePayment(payment);
//			
//			Loyality loyality =loyaltyAccountService.fetchLoyaltyByUserId(payment.getUserId());
//			loyality.setPointsBalance(loyality.getPointsBalance()+(payment.getAmount()/5));
//			loyaltyAccountService.updateLoyalty(loyality.getLoyaltyID(), loyality);
//			System.out.println(loyality);
//			booking.setPaymentID(saved.getPaymentId());
//			bookingService.saveBooking(booking);
//
//			return ResponseEntity.ok("Saved");
//		} else {
//			return ResponseEntity.status(400).body("Payment failed. Status: " + payment.getStatus());
//		}
//	}
//
//	public int getPaymentIdByBookingId(int bookingId) {
//		return paymentRepository.findByBookingId(bookingId).map(Payment::getPaymentId)
//				.orElseThrow(() -> new RuntimeException("Payment not found for Booking ID: " + bookingId));
//	}
//
//	public Payment fetchPaymentById(int paymentId) {
//
//		return paymentDao.fetchPaymentById(paymentId);
//	}
//
//	public Payment deletePaymentById(int paymentId) {
//
//		return paymentDao.deletePaymentById(paymentId);
//	}
//
//	public Payment updatePaymentById(int oldpaymentId, Payment newPayment) {
//
//		return paymentDao.updatePaymentById(oldpaymentId, newPayment);
//
//	}
//
//	public List<Payment> fetchAllPayment() {
//		return paymentDao.fetchAllPayment();
//	}
//
//}

package com.cts.hotel.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.hotel.DAO.PaymentDao;
import com.cts.hotel.Model.Booking;
import com.cts.hotel.Model.Loyality;
import com.cts.hotel.Model.Payment;
import com.cts.hotel.Model.PaymentStatus;
import com.cts.hotel.Repo.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private LoyaltyAccountService loyaltyAccountService;

    public ResponseEntity<String> savePayment(Payment payment) {
        int bookingId = payment.getBookingId();
        ResponseEntity<Booking> response = bookingService.getById(bookingId);
        Booking booking = response.getBody();

        if (booking == null || response.getStatusCode().is4xxClientError()) {
            return ResponseEntity.badRequest().body("Invalid booking ID: " + bookingId);
        }

        if (payment.getStatus() == PaymentStatus.SUCCESS) {
            Payment saved = paymentDao.savePayment(payment);
            Loyality loyalty = loyaltyAccountService.fetchLoyaltyByUserId(payment.getUserId());
            System.out.println("Loyality:"+loyalty);
            if (loyalty == null) {
                loyalty = new Loyality();
                loyalty.setUserID(payment.getUserId());
                loyalty.setPointsBalance(payment.getAmount() / 5);
                loyalty.setLastUpdated(new Date());
                loyaltyAccountService.saveLoyalty(loyalty);
            } else {
                int currentPoints = loyalty.getPointsBalance();
                int newPoints = payment.getAmount() / 5;
                int updatedPoints = currentPoints + newPoints;
                loyalty.setPointsBalance(updatedPoints);
                loyalty.setLastUpdated(new Date());
                loyaltyAccountService.updateLoyalty(loyalty.getLoyaltyID(), loyalty);
            }


            booking.setPaymentID(saved.getPaymentId());
            bookingService.saveBooking(booking);

            return ResponseEntity.ok("Payment saved and loyalty points updated.");
        } else {
            return ResponseEntity.badRequest().body("Payment failed. Status: " + payment.getStatus());
        }
    }

    public int getPaymentIdByBookingId(int bookingId) {
        return paymentRepository.findByBookingId(bookingId)
                .map(Payment::getPaymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found for Booking ID: " + bookingId));
    }

    public Payment fetchPaymentById(int paymentId) {
        return paymentDao.fetchPaymentById(paymentId);
    }

    public Payment deletePaymentById(int paymentId) {
        return paymentDao.deletePaymentById(paymentId);
    }

    public Payment updatePaymentById(int oldPaymentId, Payment newPayment) {
        return paymentDao.updatePaymentById(oldPaymentId, newPayment);
    }

    public List<Payment> fetchAllPayment() {
        return paymentDao.fetchAllPayment();
    }
}
