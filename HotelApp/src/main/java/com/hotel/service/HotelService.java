package com.hotel.service;

import java.util.List;

import com.hotel.entities.Hotel;

public interface HotelService {

	Hotel getHotel(int hotelId);
	
	List<Hotel> getAllHotels();
	
	Hotel saveHotel(Hotel hotel);
	
	void deleteHotel(int hotelId);
	
	void updateHotel(Hotel hotel);
	
	
}
