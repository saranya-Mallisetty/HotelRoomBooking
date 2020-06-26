package com.example.Hotel.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Hotel.model.BookingDetails;
@Repository
public interface BookingDao extends CrudRepository<BookingDetails, Integer>  {

	Optional<BookingDetails> findAllByRoomId(int roomId);

}
