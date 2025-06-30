package com.cts.hotel.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hotel.Model.Loyality;
import com.cts.hotel.Repo.LoyalityRepo;

@Service
public class LoyaltyAccountService {

	@Autowired
	private LoyalityRepo loyalityRepo;

	public Loyality saveLoyalty(Loyality loyaltyAccount) {
		return loyalityRepo.save(loyaltyAccount);
	}

	public Loyality fetchLoyaltyById(int loyaltyId) {

		return loyalityRepo.findByLoyaltyID(loyaltyId);
	}
	
	public Loyality fetchLoyaltyByUserId(int id) {

		return loyalityRepo.findByUserID(id);
	} 

	public void deleteLoyaltyById(int loyaltyId) {
		loyalityRepo.deleteById(loyaltyId);

	}

	public Loyality updateLoyalty(int oldLoyaltyId, Loyality newLoyalty) {

		newLoyalty.setLoyaltyID(oldLoyaltyId);
		return loyalityRepo.save(newLoyalty);
	}

	public List<Loyality> fetchAllLoyalty() {
		return loyalityRepo.findAll();
	}

}
