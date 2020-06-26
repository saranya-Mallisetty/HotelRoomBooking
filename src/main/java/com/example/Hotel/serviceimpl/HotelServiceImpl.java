package com.example.Hotel.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hotel.dao.HotelDao;
import com.example.Hotel.dao.RoomDao;
import com.example.Hotel.dto.HotelRequestDto;
import com.example.Hotel.dto.HotelResponseDto;
import com.example.Hotel.dto.RoomResponseDto;
import com.example.Hotel.model.HotelDetails;
import com.example.Hotel.model.RoomDetails;
import com.example.Hotel.model.RoomStatus;
import com.example.Hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	private static Log logger = LogFactory.getLog(HotelServiceImpl.class);

	@Autowired
	HotelDao hoteldao;
	@Autowired
	RoomDao roomdao;

	@Override
	public List<HotelResponseDto> searchHotelDetails(HotelRequestDto hotelRequestDto) {
		logger.info("Inside searchhoteldetails of Hotel servic impl");
		 // List<HotelResponseDto> hotelResponseDtoList = new
		// ArrayList<HotelResponseDto>();
		Optional<List<HotelDetails>> hotelDetails = hoteldao.findHotelDetailsByLocation(hotelRequestDto.getLocation());
		System.out.println(hotelDetails);
		System.out.println(hotelDetails);

		LocalDate date = LocalDate.parse(hotelRequestDto.getBookingDate());

		List<List<RoomDetails>> roomdetailsList = hotelDetails.get().stream()
				.map(hotelDetail -> (roomdao.findRoomDetailsByHotelId(hotelDetail.getHotelId())))
				.collect(Collectors.toList());
		System.out.println(roomdetailsList);
		List<RoomDetails> availablerooms = new ArrayList<>();
		for (List<RoomDetails> roomDetails : roomdetailsList) {
			List<RoomDetails> availableroomDetails = roomDetails.stream().filter(roomdetail -> {
				List<RoomStatus> roomStatusList = roomdetail.getRoomStatus();
				for (RoomStatus roomStatus : roomStatusList) {

					if (!roomStatus.getDate().equals(date)) {
						return true;
					}
				}
				return false;

			}).collect(Collectors.toList());
			availablerooms.addAll(availableroomDetails);
			System.out.println(availablerooms);
		}
		List<Optional<HotelDetails>> finalhoteldetails = availablerooms.stream()
				.map(room -> hoteldao.findHotelDetailsByHotelId(room.getHotelId())).collect(Collectors.toList());
		System.out.println(finalhoteldetails);
		return finalhoteldetails.stream().map(hotelDetailsOptional -> {
			if (hotelDetailsOptional.isPresent())
				return getHotelResponseDto(hotelDetailsOptional.get());
			return new HotelResponseDto();
		}).collect(Collectors.toList());

	}

	private HotelResponseDto getHotelResponseDto(HotelDetails hotelDetails) {
		logger.info("Inside getting traindetails of route servic impl");

		HotelResponseDto hotelResponseDto = new HotelResponseDto();
		BeanUtils.copyProperties(hotelDetails, hotelResponseDto);
		return hotelResponseDto;
	}

	@Override
	public List<RoomResponseDto> searchRoomDetails(int hotelId) {
		List<RoomResponseDto> roomOptionalDto = new ArrayList<>();
		Optional<List<RoomDetails>> roomDetailsList = roomdao.findAllByHotelId(hotelId);

		System.out.println(roomDetailsList);

		if (roomDetailsList.isPresent()) {
			return roomDetailsList.get().stream().map(roomDetails -> getRoomResponseDto(roomDetails))
					.collect(Collectors.toList());
		} else {
			return roomOptionalDto;
		}

	}

	private RoomResponseDto getRoomResponseDto(RoomDetails roomDetails) {
		logger.info("Inside getting traindetails of route servic impl");
		RoomResponseDto roomResponseDto = new RoomResponseDto();
		BeanUtils.copyProperties(roomDetails, roomResponseDto);
		return roomResponseDto;
	}

}
