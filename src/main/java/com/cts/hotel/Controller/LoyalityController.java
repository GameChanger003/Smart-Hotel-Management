package com.cts.hotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hotel.Model.Loyality;
import com.cts.hotel.Service.LoyaltyAccountService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user/loyality")
@CrossOrigin(origins = "*")
public class LoyalityController {
	
	@Autowired
	private LoyaltyAccountService accountService;
	
	@GetMapping
	public ResponseEntity<List<Loyality>> getAllLoaylityPoints() {
		return ResponseEntity.ok(accountService.fetchAllLoyalty());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Loyality> postMethodName(@RequestBody Loyality loyality) {
		
		return ResponseEntity.ok(accountService.saveLoyalty(loyality));
	}
	
	@DeleteMapping("/delete/")
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	
	
}
