package com.example.Hotel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hotel.dto.BookingRequestDto;
import com.example.Hotel.dto.BookingResponseDto;
import com.example.Hotel.dto.GuestRequestDto;
import com.example.Hotel.service.BookingService;
import com.example.Hotel.service.GuestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class BookingController {
	@Autowired
	BookingService bookingService;
	
	@Autowired
	GuestService guestService;

	@PostMapping("/booking")
	public ResponseEntity<BookingResponseDto> bookingDetails(@RequestBody BookingRequestDto bookingRequestDto) {
		BookingResponseDto bookingResponseDto = bookingService.bookingDetails(bookingRequestDto);
		return new ResponseEntity<BookingResponseDto>(bookingResponseDto, HttpStatus.CREATED);
	}

	
	@PostMapping("booking/{bookingId}/guest")
    public ResponseEntity<String> addguestDetails(@RequestBody List<GuestRequestDto> guestRequestDtoList,@PathVariable("bookingId") int bookingId)
    {
        guestService.addGuestDetails(guestRequestDtoList,bookingId);
        return new ResponseEntity<String>("Guest details added",HttpStatus.CREATED);
    }
}
