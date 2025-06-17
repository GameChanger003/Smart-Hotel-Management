package com.cts.hotel.Repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.hotel.Model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

	Optional<Booking> findById(Integer id); 
	@Query("SELECT b FROM Booking b WHERE b.RoomID = :roomID AND " +
		       "(b.CheckInDate <= :checkOutDate AND b.CheckOutDate >= :checkInDate)")
		List<Booking> findConflictingBookings(@Param("roomID") int roomID,
		                                      @Param("checkInDate") Date checkInDate,
		                                      @Param("checkOutDate") Date checkOutDate);
}
