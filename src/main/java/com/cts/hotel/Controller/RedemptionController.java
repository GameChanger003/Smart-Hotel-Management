package com.cts.hotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hotel.Model.Redemption;
import com.cts.hotel.Service.RedemptionService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/user/redemption")
@CrossOrigin(origins = "*")
public class RedemptionController {
	
	@Autowired
	private RedemptionService redemptionService;

	@GetMapping
	public ResponseEntity<?> getAllPoints() {
		return ResponseEntity.ok(redemptionService.getRedemption());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Redemption> postMethodName(@RequestBody Redemption redemption) {
		
		return ResponseEntity.ok(redemptionService.saveRedemption(redemption));
	}
	
}
