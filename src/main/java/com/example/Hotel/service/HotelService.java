package com.example.Hotel.service;

import java.util.List;

import com.example.Hotel.dto.HotelRequestDto;
import com.example.Hotel.dto.HotelResponseDto;
import com.example.Hotel.dto.RoomResponseDto;

public interface HotelService {

	List<HotelResponseDto> searchHotelDetails(HotelRequestDto hotelRequestDto);

	List<RoomResponseDto> searchRoomDetails(int hotelId);

}
