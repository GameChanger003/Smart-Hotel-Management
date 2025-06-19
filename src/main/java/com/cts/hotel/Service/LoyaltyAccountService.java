package com.cts.hotel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hotel.DAO.LoyaltyAccountDao;
import com.cts.hotel.Model.LoyaltyAccount;

@Service
public class LoyaltyAccountService {
	
	
	@Autowired
	private LoyaltyAccountDao loyaltyAccountDao;
	
	
	public LoyaltyAccount saveLoyalty(LoyaltyAccount loyaltyAccount) {
		return loyaltyAccountDao.saveLoyalty(loyaltyAccount);
	}
	
	public LoyaltyAccount fetchLoyaltyById(int loyaltyId) {
		
		return loyaltyAccountDao.fetchLoyaltyById(loyaltyId);
	}
	
	public LoyaltyAccount deleteLoyaltyById(int loyaltyId) {
		return loyaltyAccountDao.deleteLoyaltyById(loyaltyId);
		
	}
	
	public LoyaltyAccount updateLoyalty(int oldLoyaltyId,LoyaltyAccount newLoyalty) {
		return loyaltyAccountDao.updateLoyalty(oldLoyaltyId, newLoyalty);
	}
	
	public List<LoyaltyAccount> fetchAllLoyalty(){
		return loyaltyAccountDao.fetchAllLoyalty();
	}
	


}
