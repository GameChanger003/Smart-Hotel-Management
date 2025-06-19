package com.cts.hotel.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.hotel.Model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
