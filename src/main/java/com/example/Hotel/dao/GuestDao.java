package com.example.Hotel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Hotel.model.GuestDetails;
@Repository
public interface GuestDao extends CrudRepository<GuestDetails, Integer> {

}
