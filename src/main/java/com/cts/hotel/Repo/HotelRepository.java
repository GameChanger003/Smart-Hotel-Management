package com.cts.hotel.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.hotel.Model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
