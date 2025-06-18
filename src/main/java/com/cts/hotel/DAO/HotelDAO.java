package com.cts.hotel.DAO;

import java.util.List;

import com.cts.hotel.Model.Hotel;

public interface HotelDAO {
	List<Hotel> getAllHotels();

	Hotel getHotelById(int id);

	Hotel addHotel(Hotel hotel);

	Hotel updateHotel(int oldHotelID, Hotel newHotel);

	void deleteHotel(int id);
}
