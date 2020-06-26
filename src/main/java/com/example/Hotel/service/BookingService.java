package com.example.Hotel.service;

import com.example.Hotel.dto.BookingRequestDto;
import com.example.Hotel.dto.BookingResponseDto;

public interface BookingService {

	BookingResponseDto bookingDetails(BookingRequestDto bookingRequestDto);

}
