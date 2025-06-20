package com.cts.hotel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hotel.DAO.LoyaltyAccountDao;
<<<<<<< HEAD
import com.cts.hotel.Model.LoyaltyAccount;
=======
import com.cts.hotel.Model.Loyality;
>>>>>>> fb0a3d7 (added loyality & Redemption)

@Service
public class LoyaltyAccountService {
	
	
	@Autowired
	private LoyaltyAccountDao loyaltyAccountDao;
	
	
<<<<<<< HEAD
	public LoyaltyAccount saveLoyalty(LoyaltyAccount loyaltyAccount) {
		return loyaltyAccountDao.saveLoyalty(loyaltyAccount);
	}
	
	public LoyaltyAccount fetchLoyaltyById(int loyaltyId) {
=======
	public Loyality saveLoyalty(Loyality loyaltyAccount) {
		return loyaltyAccountDao.saveLoyalty(loyaltyAccount);
	}
	
	public Loyality fetchLoyaltyById(int loyaltyId) {
>>>>>>> fb0a3d7 (added loyality & Redemption)
		
		return loyaltyAccountDao.fetchLoyaltyById(loyaltyId);
	}
	
<<<<<<< HEAD
	public LoyaltyAccount deleteLoyaltyById(int loyaltyId) {
=======
	public Loyality deleteLoyaltyById(int loyaltyId) {
>>>>>>> fb0a3d7 (added loyality & Redemption)
		return loyaltyAccountDao.deleteLoyaltyById(loyaltyId);
		
	}
	
<<<<<<< HEAD
	public LoyaltyAccount updateLoyalty(int oldLoyaltyId,LoyaltyAccount newLoyalty) {
		return loyaltyAccountDao.updateLoyalty(oldLoyaltyId, newLoyalty);
	}
	
	public List<LoyaltyAccount> fetchAllLoyalty(){
=======
	public Loyality updateLoyalty(int oldLoyaltyId,Loyality newLoyalty) {
		return loyaltyAccountDao.updateLoyalty(oldLoyaltyId, newLoyalty);
	}
	
	public List<Loyality> fetchAllLoyalty(){
>>>>>>> fb0a3d7 (added loyality & Redemption)
		return loyaltyAccountDao.fetchAllLoyalty();
	}
	


}
