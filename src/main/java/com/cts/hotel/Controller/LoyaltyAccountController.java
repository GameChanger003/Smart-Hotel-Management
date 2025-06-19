package com.cts.hotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hotel.Model.LoyaltyAccount;
import com.cts.hotel.Service.LoyaltyAccountService;


@RestController
@RequestMapping("/user/loyalty")
@CrossOrigin(origins = "*")
public class LoyaltyAccountController {
	
	
	@Autowired
	private LoyaltyAccountService loyaltyAccountService;
	
	
	@PostMapping("/saveLoyalty")
	public LoyaltyAccount saveLoyalty(LoyaltyAccount loyaltyAccount) {
		System.out.println(loyaltyAccount);
		return loyaltyAccountService.saveLoyalty(loyaltyAccount);
	}
	
	@GetMapping("/fetchLoyaltyById")
	public LoyaltyAccount fetchLoyaltyById(int loyaltyId) {
		
		return loyaltyAccountService.fetchLoyaltyById(loyaltyId);
	}
	
	@DeleteMapping("/deleteLoyaltyById")
	public LoyaltyAccount deleteLoyaltyById(int loyaltyId) {
		return loyaltyAccountService.deleteLoyaltyById(loyaltyId);
		
	}
	
	@PutMapping("/updateLoyalty")
	public LoyaltyAccount updateLoyalty(int oldLoyaltyId,LoyaltyAccount newLoyalty) {
		return loyaltyAccountService.updateLoyalty(oldLoyaltyId, newLoyalty);
	}
	
	@GetMapping("/fetchAllLoyalty")
	public List<LoyaltyAccount> fetchAllLoyalty(){
		return loyaltyAccountService.fetchAllLoyalty();
	}

}
