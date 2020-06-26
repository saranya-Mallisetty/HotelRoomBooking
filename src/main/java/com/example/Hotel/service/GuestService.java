package com.example.Hotel.service;

import java.util.List;

import com.example.Hotel.dto.GuestRequestDto;

public interface GuestService {

	void addGuestDetails(List<GuestRequestDto> guestRequestDtoList, int bookingId);

}
