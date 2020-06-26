package com.example.Hotel.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Hotel.controller.HotelController;
import com.example.Hotel.dto.HotelRequestDto;
import com.example.Hotel.dto.HotelResponseDto;
import com.example.Hotel.dto.RoomResponseDto;
import com.example.Hotel.service.HotelService;

@ExtendWith(MockitoExtension.class)

public class HotelControllerTest {

	@InjectMocks
	HotelController hotelController;

	@Mock
	HotelService hotelService;

	@Test
	public void findHotelDetails() {

		List<HotelResponseDto> login = new ArrayList<HotelResponseDto>();
		HotelResponseDto l = new HotelResponseDto();
		l.setHotelName("saru");
		l.setHotelId(1);

		l.setContactNumber("123456789");
		login.add(l);

		HotelResponseDto l1 = new HotelResponseDto();
		l1.setHotelName("saru");
		l1.setHotelId(1);

		l1.setContactNumber("123456789");
		login.add(l1);

		HotelRequestDto hotel = new HotelRequestDto();

		Mockito.when(hotelService.searchHotelDetails(hotel)).thenReturn(Mockito.any());

		ResponseEntity<List<HotelResponseDto>> responsebusdetailsdto = hotelController.findHotelDetails(hotel);
		assertEquals(HttpStatus.OK, responsebusdetailsdto.getStatusCode());

	}

	@Test

	public void findRoomDetails() {
		
		
		
		List<HotelResponseDto> login = new ArrayList<HotelResponseDto>();
		HotelResponseDto l = new HotelResponseDto();
		l.setHotelName("saru");
		l.setHotelId(1);

		l.setContactNumber("123456789");
		login.add(l);

		HotelResponseDto l1 = new HotelResponseDto();
		l1.setHotelName("saru");
		l1.setHotelId(1);

		l1.setContactNumber("123456789");
		login.add(l1);


		Mockito.when(hotelService.searchRoomDetails(1)).thenReturn(Mockito.any());

		ResponseEntity<List<RoomResponseDto>> responsebusdetailsdto = hotelController.findRoomDetails(1);
		assertEquals(HttpStatus.OK, responsebusdetailsdto.getStatusCode());



	}

}
