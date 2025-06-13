package com.cts.hotel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hotel.DAO.HotelDAO;
import com.cts.hotel.Model.Hotel;
import com.cts.hotel.Repo.HotelRepository;

@Service
public class HotelService implements HotelDAO {

	@Autowired
	private HotelRepository hotelRepository;

	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	public Hotel getHotelById(int id) {
		return hotelRepository.findById(id).orElse(null);
	}

	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	public Hotel updateHotel(int oldHotelID, Hotel newHotel) {
		newHotel.setHotelID(oldHotelID);
		return addHotel(newHotel);
	}

	public void deleteHotel(int id) {
		hotelRepository.deleteById(id);
	}
}
