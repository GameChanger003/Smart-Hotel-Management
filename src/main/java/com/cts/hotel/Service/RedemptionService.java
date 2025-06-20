package com.cts.hotel.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hotel.Model.Redemption;
import com.cts.hotel.Repo.RedemptionRepo;

@Service
public class RedemptionService {
	
	@Autowired
	private RedemptionRepo redemptionRepo;
	
	public Redemption saveRedemption(Redemption redemption){
		return redemptionRepo.save(redemption);
	}

}
