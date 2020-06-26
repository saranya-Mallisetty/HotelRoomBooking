package com.example.Hotel.service;

import com.example.Hotel.dto.UserDto;
import com.example.Hotel.exception.InvalidCredentialsException;

public interface UserService {

	/**
	 * 
	 * This method is used to register User
	 * @param userDto
	 */
	public void addUser(UserDto userDto);

	/**
	 * This method is used to authenticate User
	 * @param loginDto
	 * @return boolean true if an authenticated User else false
	 * @throws InvalidCredentialsException 
	 */
	public boolean authenticateUser(String userName, String password) throws InvalidCredentialsException;
}
