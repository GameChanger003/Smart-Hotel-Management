package com.cts.hotel.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.hotel.Model.LoyaltyAccount;
import com.cts.hotel.Repo.LoyaltyAccountRepository;

@Repository
public class LoyaltyAccountDao {
	
	
	@Autowired
	private LoyaltyAccountRepository loyaltyAccountRepository;
	
	
	
	public LoyaltyAccount saveLoyalty(LoyaltyAccount loyaltyAccount) {
		return loyaltyAccountRepository.save(loyaltyAccount);
	}
	
	public LoyaltyAccount fetchLoyaltyById(int loyaltyId) {
		
		return loyaltyAccountRepository.findById(loyaltyId).get();
	}
	
	public LoyaltyAccount deleteLoyaltyById(int loyaltyId) {
		LoyaltyAccount loyaltyAccount=fetchLoyaltyById(loyaltyId);
		loyaltyAccountRepository.delete(loyaltyAccount);
		return loyaltyAccount;
		
	}
	
	public LoyaltyAccount updateLoyalty(int oldLoyaltyId,LoyaltyAccount newLoyalty) {
		newLoyalty.setLoyaltyId(oldLoyaltyId);
		return saveLoyalty(newLoyalty);
	}
	
	public List<LoyaltyAccount> fetchAllLoyalty(){
		return loyaltyAccountRepository.findAll();
	}
	

}
