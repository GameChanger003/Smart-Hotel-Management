package com.cts.hotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hotel.Model.Hotel;
import com.cts.hotel.Service.HotelService;

@RestController
@RequestMapping("/Manager/hotels")
@CrossOrigin(origins = "*")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping
	public List<Hotel> getAllHotels() {
		return hotelService.getAllHotels();
	}

	@GetMapping("/{id}")
	public Hotel getHotelById(@PathVariable int id) {
		return hotelService.getHotelById(id);
	}

	@PostMapping("/add")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		return hotelService.addHotel(hotel);
	}

	@PutMapping("/update/{oldHotelID}")
	public Hotel updateHotel(@PathVariable int oldHotelID, @RequestBody Hotel newHotel) {
		return hotelService.updateHotel(oldHotelID, newHotel);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteHotel(@PathVariable int id) {
		hotelService.deleteHotel(id);
	}
}
