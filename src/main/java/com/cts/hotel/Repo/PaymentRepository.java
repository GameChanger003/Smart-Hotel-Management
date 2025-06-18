package com.cts.hotel.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.hotel.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	Optional<Payment> findByBookingId(int bookingId);
	

}
