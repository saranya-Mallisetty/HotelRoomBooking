package com.example.Hotel.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hotel.dto.HotelRequestDto;
import com.example.Hotel.dto.HotelResponseDto;
import com.example.Hotel.dto.RoomResponseDto;
import com.example.Hotel.service.HotelService;

@RestController
public class HotelController {
	@Autowired
	HotelService hotelservice;
	private static Log logger = LogFactory.getLog(HotelController.class);

	@PostMapping("/hotel/searchhotel")
	public ResponseEntity<List<HotelResponseDto>> findHotelDetails(@RequestBody HotelRequestDto hotelRequestDto) {
		logger.info("Inside Searching based on sourceanddestination getting hotel details");

		List<HotelResponseDto> hotelResponsedto = hotelservice.searchHotelDetails(hotelRequestDto);

		return new ResponseEntity<List<HotelResponseDto>>(hotelResponsedto, HttpStatus.OK);

	}

	@GetMapping("/hotel/{hotelId}/roomdetails")
	public ResponseEntity<List<RoomResponseDto>> findRoomDetails(@PathVariable("hotelId") int hotelId) {
		logger.info("Inside Searching based on sourceanddestination getting hotel details");

		List<RoomResponseDto> roomResponsedto = hotelservice.searchRoomDetails(hotelId);

		return new ResponseEntity<List<RoomResponseDto>>(roomResponsedto, HttpStatus.OK);

	}

}
