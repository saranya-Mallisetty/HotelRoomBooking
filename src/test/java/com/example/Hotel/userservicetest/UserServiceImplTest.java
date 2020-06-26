package com.example.Hotel.userservicetest;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Hotel.dao.UserDao;
import com.example.Hotel.dto.UserDto;
import com.example.Hotel.exception.InvalidCredentialsException;
import com.example.Hotel.model.User;
import com.example.Hotel.serviceimpl.UserServiceImpl;



@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
    User user;
	
	@Mock
	UserDao userDao;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	UserDto userDto;
	
	@BeforeEach
	public void setUp()
	{
		
		userDto=new UserDto();
		userDto.setUserName("saru");
		userDto.setPassword("saru");
		userDto.setMobileNumber("9849215392");
		userDto.setEmailId("saru@gmail.com");
		userDto.setLocation("nellore");
	}
	@Test
	public void saveUser()
	{
		//given
		when(userDao.save(any(User.class))).thenReturn(any(User.class));
		
		//when
		userServiceImpl.addUser(userDto);
		
		//then
		verify(userDao).save(any(User.class));
		
	}
	
	@Test
	public void authenticateTest1() throws InvalidCredentialsException {
		//given
		User user=new User();
		user.setUserName("saru");
		user.setPassword("saru");
		
		
		when(userDao.findByUserNameAndPassword("saru","saru")).thenReturn(user);
				
		
		//when
		Boolean isExists = userServiceImpl.authenticateUser("saru", "saru");
		
		//then
		verify(userDao).findByUserNameAndPassword("saru","saru");
		assertTrue(isExists);
	}
	
	@Test
	public void authenticateTest2() {
		//given
		User user = new User();
		user.setUserName("saru");
		user.setPassword("saru");	
		
		when(userDao.findByUserNameAndPassword("saru","saru")).thenReturn(null);
		
		//when
		
		//then
		assertThrows(InvalidCredentialsException.class, () -> userServiceImpl.authenticateUser("saru", "saru"));
	}
	
	

}
