package com.cts.hotel.Repo;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import com.cts.hotel.Model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Optional<Booking> findById(Integer id);

    @Query("SELECT b FROM Booking b WHERE b.RoomId = :roomId AND b.Status = 'BOOKED' AND " +
    	       "(:checkInDate <= b.CheckOutDate AND :checkOutDate >= b.CheckInDate)")
    	List<Booking> findConflictingBookings(@Param("roomId") int roomId,
    	                                      @Param("checkInDate") Date checkIn,
    	                                      @Param("checkOutDate") Date checkOut);

}
