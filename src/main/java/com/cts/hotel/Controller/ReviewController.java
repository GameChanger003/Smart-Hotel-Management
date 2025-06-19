package com.cts.hotel.Controller;

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
import com.cts.hotel.Model.Review;
import com.cts.hotel.Service.ReviewService;

@RequestMapping("/Reviews")
@RestController
@CrossOrigin(origins="*")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService ;
	
	@PostMapping("/saveReview")
	public ResponseEntity<?> saveReview(@RequestBody Review review) 
	{
		System.out.println(review);
		return (ResponseEntity<?>) reviewService.saveReview(review);
		
	}
	@GetMapping("/fetchReviewById")
	public Review fetchReviewById(@RequestParam int reviewId) {
		return reviewService.fetchReviewById(reviewId);
	}
	
	@DeleteMapping("/deleteReviewById")
	public Review deleteReviewById(@RequestParam int reviewId) {
		return reviewService.deleteReviewById(reviewId);
	}
	
	@PutMapping("/updateReview")
	public Review updateReview(@RequestParam int oldReviewId, @RequestBody Review newReviewId) {
		
		return reviewService.updateReview(oldReviewId, newReviewId);
		
	}

	@GetMapping("/fetchAllReview")
	public List<Review> fetchAllReview(){ 
		return reviewService.fetchAllReview();
	}
	

	

}
