package com.cts.hotel.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.hotel.Model.Booking;
import com.cts.hotel.Model.User;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

	Optional<Booking> findById(Integer id); 

}
