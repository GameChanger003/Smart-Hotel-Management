package com.cts.hotel.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.hotel.Model.Loyality;

@Repository
public interface LoyalityRepo extends JpaRepository<Loyality, Integer> {
    Loyality findByLoyaltyID(int loyaltyID);
    Loyality findByUserID(int userID);
}

