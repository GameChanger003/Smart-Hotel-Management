//package com.cts.hotel.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//<<<<<<< HEAD
//import com.cts.hotel.Model.LoyaltyAccount;
//=======
//import com.cts.hotel.Model.Loyality;
//>>>>>>> fb0a3d7 (added loyality & Redemption)
//import com.cts.hotel.Service.LoyaltyAccountService;
//
//
//@RestController
//@RequestMapping("/user/loyalty")
//@CrossOrigin(origins = "*")
//public class LoyaltyAccountController {
//
//
//	@Autowired
//	private LoyaltyAccountService loyaltyAccountService;
//
//
//	@PostMapping("/saveLoyalty")
//<<<<<<< HEAD
//	public LoyaltyAccount saveLoyalty(LoyaltyAccount loyaltyAccount) {
//=======
//	public Loyality saveLoyalty(Loyality loyaltyAccount) {
//>>>>>>> fb0a3d7 (added loyality & Redemption)
//		System.out.println(loyaltyAccount);
//		return loyaltyAccountService.saveLoyalty(loyaltyAccount);
//	}
//
//	@GetMapping("/fetchLoyaltyById")
//<<<<<<< HEAD
//	public LoyaltyAccount fetchLoyaltyById(int loyaltyId) {
//=======
//	public Loyality fetchLoyaltyById(int loyaltyId) {
//>>>>>>> fb0a3d7 (added loyality & Redemption)
//
//		return loyaltyAccountService.fetchLoyaltyById(loyaltyId);
//	}
//
//	@DeleteMapping("/deleteLoyaltyById")
//<<<<<<< HEAD
//	public LoyaltyAccount deleteLoyaltyById(int loyaltyId) {
//=======
//	public Loyality deleteLoyaltyById(int loyaltyId) {
//>>>>>>> fb0a3d7 (added loyality & Redemption)
//		return loyaltyAccountService.deleteLoyaltyById(loyaltyId);
//
//	}
//
//	@PutMapping("/updateLoyalty")
//<<<<<<< HEAD
//	public LoyaltyAccount updateLoyalty(int oldLoyaltyId,LoyaltyAccount newLoyalty) {
//=======
//	public Loyality updateLoyalty(int oldLoyaltyId,Loyality newLoyalty) {
//>>>>>>> fb0a3d7 (added loyality & Redemption)
//		return loyaltyAccountService.updateLoyalty(oldLoyaltyId, newLoyalty);
//	}
//
//	@GetMapping("/fetchAllLoyalty")
//<<<<<<< HEAD
//	public List<LoyaltyAccount> fetchAllLoyalty(){
//=======
//	public List<Loyality> fetchAllLoyalty(){
//>>>>>>> fb0a3d7 (added loyality & Redemption)
//		return loyaltyAccountService.fetchAllLoyalty();
//	}
//
//}
