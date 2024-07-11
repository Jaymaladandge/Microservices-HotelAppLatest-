package com.hotel.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	
	private static final Logger logger = LogManager.getLogger(HotelController.class);
	//private Logger logger = LoggerFactory.getLogger(HotelController.class);

	
	@PostMapping("/save")
	public ResponseEntity<Hotel> persistHotel(@RequestBody Hotel hotel){
		Hotel hotel2 = hotelService.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel2);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		logger.info("=========================getAll()=======================");
		List<Hotel> hotels = hotelService.getAllHotels();
		return ResponseEntity.ok(hotels);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelInfo(@PathVariable int hotelId){
		Hotel hotel = hotelService.getHotel(hotelId);
		logger.info("============getHotelInfo==========="+hotel);
		return ResponseEntity.ok(hotel);
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> editHotelInfo(@RequestBody Hotel hotel){
		hotelService.updateHotel(hotel);
		return ResponseEntity.status(HttpStatus.OK).body("Hotel updated");
	}
	
	@GetMapping("/delete/{hotelId}")
	public ResponseEntity<String> delete(@PathVariable int hotelId){
		hotelService.deleteHotel(hotelId);
		return ResponseEntity.ok("Hotel deleted");
	}
}
