package com.hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entities.Hotel;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositories.HotelRepository;
import com.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel getHotel(int hotelId) {
		return hotelRepo.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel with given id is not found : " + hotelId));
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepo.save(hotel);
	}

	@Override
	public void deleteHotel(int hotelId) {
		hotelRepo.deleteById(hotelId);
	}

	@Override
	public void updateHotel(Hotel hotel) {
		Optional<Hotel> hotel1 = hotelRepo.findById(hotel.getHotelId());
		hotel1.ifPresent(savedHotel -> {
				savedHotel.setName(hotel.getName());
				savedHotel.setLocation(hotel.getLocation());
				savedHotel.setAbout(hotel.getAbout());
				hotelRepo.save(savedHotel);
		});
	}

}
