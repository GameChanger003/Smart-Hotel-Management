package com.cts.hotel.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hotel.Model.Loyality;
import com.cts.hotel.Model.Redemption;
import com.cts.hotel.Repo.LoyalityRepo;
import com.cts.hotel.Repo.RedemptionRepo;
//• Redemption (RedemptionID, UserID, BookingID, PointsUsed, DiscountAmount)

//• LoyaltyAccount (LoyaltyID, UserID, PointsBalance, LastUpdated)


@Service
public class RedemptionService {
	
	@Autowired
	private RedemptionRepo redemptionRepo;
	
	@Autowired
	private LoyalityRepo loyalityRepo;
	
	public Redemption saveRedemption(Redemption redemption){
		Loyality loyality= loyalityRepo.findByUserID(redemption.getUserID());
		System.out.println(loyality);
		int points=loyality.getPointsBalance()-redemption.getPointsUsed();
		System.out.println(points);
		loyality.setPointsBalance(points);
		loyality.setLastUpdated(new Date());
		loyalityRepo.save(loyality);
		return redemptionRepo.save(redemption);
	}
	
	public List<Redemption> getRedemption() {
		return redemptionRepo.findAll();
	}

}
