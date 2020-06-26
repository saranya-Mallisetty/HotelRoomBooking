package com.example.Hotel.serviceimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hotel.dao.BookingDao;
import com.example.Hotel.dto.BookingRequestDto;
import com.example.Hotel.dto.BookingResponseDto;
import com.example.Hotel.model.BookingDetails;
import com.example.Hotel.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDao bookingDao;

	@Override
	public BookingResponseDto bookingDetails(BookingRequestDto bookingRequestDto) {

		BookingDetails bookingdetails = new BookingDetails();

		bookingdetails.setUserId(bookingRequestDto.getUserId());
		bookingdetails.setRoomId(bookingRequestDto.getRoomId());
		bookingdetails.setNoOfGuest(bookingRequestDto.getNoOfGuest());

		LocalDate date = LocalDate.parse(bookingRequestDto.getCheckInDate());
		bookingdetails.setCheckInDate(date);
		LocalDate date1 = LocalDate.parse(bookingRequestDto.getCheckOutDate());
		bookingdetails.setCheckOutDate(date1);

		LocalTime time = LocalTime.parse(bookingRequestDto.getCheckInTime());
		bookingdetails.setCheckInTime(time);
		LocalTime time1 = LocalTime.parse(bookingRequestDto.getCheckOutTime());
		bookingdetails.setCheckOutTime(time1);

		bookingDao.save(bookingdetails);

		Optional<BookingDetails> bookingDetailsList = bookingDao.findAllByRoomId(bookingRequestDto.getRoomId());

		BookingResponseDto bookingResponeDto = new BookingResponseDto();

		bookingResponeDto.setBookingId(bookingDetailsList.get().getBookingID());
		bookingResponeDto.setMessage("Booking got successfully Add Passenger Details");
		return bookingResponeDto;
	}

}
