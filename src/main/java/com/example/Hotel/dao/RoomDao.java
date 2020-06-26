package com.example.Hotel.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Hotel.model.RoomDetails;

@Repository
public interface RoomDao extends CrudRepository<RoomDetails, Integer>  {


	//Optional<List<RoomDetails>> findRoomDetailsByBookingDateAndHotelId(int hotelId, Date date);
	List<RoomDetails> findRoomDetailsByHotelId(int hotelId);

	Optional<List<RoomDetails>> findAllByHotelId(int hotelId);




}
