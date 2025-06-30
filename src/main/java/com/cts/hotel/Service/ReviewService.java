package com.cts.hotel.Service;




import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.hotel.DAO.ReviewDao;
import com.cts.hotel.Model.Booking;
import com.cts.hotel.Model.Review;
import com.cts.hotel.Model.Room;
import com.cts.hotel.Repo.BookingRepository;
import com.cts.hotel.Repo.RoomRepository;


@Service
public class ReviewService {
	
	@Autowired
	ReviewDao reviewDao ;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
    RoomRepository roomRepository;
	
//
//	public List<Booking> saveReview(Review review) {
//	    // Fetch the booking associated with the user and hotel
//	    List<Booking> booking = bookingRepository.findPreviousBookingsByUserId(review.getUser());
//	    System.out.println(booking);
//	    if (booking == null) {
//	    	System.out.println("errror created");
//	    }
//	    return booking;
////	    return (List<Review>) reviewDao.saveReview(review);
//	}
	
	public List<Booking> FindBookingsPast (int id) {
	    List<Booking> booking = bookingRepository.findPreviousBookingsByUserID(id);
		return booking;
		
	}
	
	public ResponseEntity<?> saveReview(Review review) {
	    List<Booking> booking = bookingRepository.findPreviousBookingsByUserID(review.getUser());
	    System.out.println(booking);
	    if (booking.isEmpty()) {
	    	return ResponseEntity.status(404).body("No data");
	    }
	    System.out.println(roomRepository.findByroomID(4));
	    int htlid=roomRepository.findByroomID(2).getHotelID();
	    review.setHotelId(htlid);
	    return ResponseEntity.status(200).body(reviewDao.saveReview(review));
	}
	
	
	
//	public Review saveReview(Review review) {
//        List<Booking> bookings = bookingRepository.findPreviousBookingsByUserId(review.getUser());
//
//        if (bookings == null || bookings.isEmpty()) {
//            throw new IllegalArgumentException("User has no completed bookings. Cannot leave a review.");
//        }
//
//        // Use the first booking (you can modify logic to choose the correct one)
//        Booking latestBooking = bookings.get(0);
//        int roomId = latestBooking.getRoomId();
//
//        Room room = roomRepository.findByroomID(roomId);
//        if (room == null) {
//            throw new IllegalStateException("Room not found for RoomID: " + roomId);
//        }
//
//        review.setHotelId(room.getHotelID());      // Set the hotel ID
//        review.setTimeStamp(new Date());         // Set current timestamp
//
//        return reviewDao.saveReview(review);
//    }

	
	
	public Review fetchReviewById(int reviewId) {
		return reviewDao.fetchReviewById(reviewId);
	}
	
	public Review deleteReviewById(int reviewId) {
		return reviewDao.deleteReviewById(reviewId);
	}
	
	public Review updateReview(int oldReviewId, Review newReviewId) {
		
		return reviewDao.updateReview(oldReviewId, newReviewId);
		
	}
	
	public List<Review> fetchAllReview(){
		return reviewDao.fetchAllReview();
	}


}
