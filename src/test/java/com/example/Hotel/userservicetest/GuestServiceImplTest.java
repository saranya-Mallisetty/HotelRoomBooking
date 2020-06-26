package com.example.Hotel.userservicetest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Hotel.dao.GuestDao;
import com.example.Hotel.dto.GuestRequestDto;
import com.example.Hotel.model.GuestDetails;
import com.example.Hotel.serviceimpl.GuestServiceImpl;


@ExtendWith(MockitoExtension.class)
public class GuestServiceImplTest {
    GuestDetails guestDetails;
	
	@Mock
	GuestDao guestdao;
	
	@InjectMocks
	GuestServiceImpl guestServiceImpl;
	
	GuestRequestDto guestRequestDtoDto;
	
	@BeforeEach
	public void setUp()
	{
		
		guestRequestDtoDto=new GuestRequestDto();
		guestRequestDtoDto.setAge(21);
		guestRequestDtoDto.setName("saru");
		guestRequestDtoDto.setGender("female");
		
	}
	@Test
	public void addGuestDetails()
	{
		//given
		when(guestdao.save(any(GuestDetails.class))).thenReturn(any(GuestDetails.class));
		
		//when
		guestServiceImpl.addGuest(guestRequestDtoDto, 0);
		
		//then
		verify(guestdao).save(any(GuestDetails.class));
		
	}
	

}
