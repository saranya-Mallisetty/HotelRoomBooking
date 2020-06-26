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

import com.example.Hotel.controller.BookingController;
import com.example.Hotel.dto.BookingRequestDto;
import com.example.Hotel.dto.BookingResponseDto;
import com.example.Hotel.dto.GuestRequestDto;
import com.example.Hotel.service.BookingService;
import com.example.Hotel.service.GuestService;

@ExtendWith(MockitoExtension.class)

public class BookingControllerTest {
	@InjectMocks
	BookingController bookingController;

	@Mock
	BookingService bookingService;
	@Mock
	GuestService guestService;

	@Test
	public void bookingDetails() {
		BookingRequestDto booking = new BookingRequestDto();
		booking.setUserId(1);
		booking.setRoomId(1);
		booking.setNoOfGuest(5);

		BookingResponseDto book = new BookingResponseDto();

		Mockito.when(bookingService.bookingDetails(booking)).thenReturn(book);

		ResponseEntity<BookingResponseDto> responsebusdetailsdto = bookingController.bookingDetails(booking);
		assertEquals(HttpStatus.CREATED, responsebusdetailsdto.getStatusCode());

	}
	
	
	
	@Test
	public void addguestDetails() {
		
		BookingRequestDto booking = new BookingRequestDto();
		booking.setUserId(1);
		booking.setRoomId(1);
		booking.setNoOfGuest(5);

		BookingResponseDto book = new BookingResponseDto();
		book.setBookingId(1);
		GuestRequestDto guest=new GuestRequestDto();
		guest.setName("saru");
		
		
		 List<GuestRequestDto> guestrequest=new  ArrayList<GuestRequestDto>();

		 ResponseEntity<String>     responsebusdetailsdto = bookingController.addguestDetails(guestrequest, 1);
		assertEquals(HttpStatus.CREATED, responsebusdetailsdto.getStatusCode());
		
	}

}
