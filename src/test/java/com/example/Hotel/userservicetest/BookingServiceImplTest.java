/*
 * package com.example.Hotel.userservicetest;
 * 
 * import static org.mockito.ArgumentMatchers.any; import static
 * org.mockito.Mockito.verify; import static org.mockito.Mockito.when;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.junit.jupiter.api.extension.ExtendWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import org.mockito.Mockito;
 * import org.mockito.junit.jupiter.MockitoExtension; import
 * org.springframework.util.Assert;
 * 
 * import com.example.Hotel.dao.BookingDao; import
 * com.example.Hotel.dto.BookingRequestDto; import
 * com.example.Hotel.dto.BookingResponseDto; import
 * com.example.Hotel.model.BookingDetails; import
 * com.example.Hotel.serviceimpl.BookingServiceImpl;
 * 
 * @ExtendWith(MockitoExtension.class) public class BookingServiceImplTest {
 * 
 * BookingDetails bookingdetails;
 * 
 * @Mock BookingDao bookingdao;
 * 
 * @InjectMocks BookingServiceImpl bookingServiceImpl;
 * 
 * BookingRequestDto bookingRequestDto;
 * 
 * BookingResponseDto bookingResponseDto;
 * 
 * 
 * 
 * @BeforeEach public void setUp() {
 * 
 * bookingRequestDto=new BookingRequestDto(); bookingRequestDto.setUserId(1);
 * bookingRequestDto.setRoomId(1); bookingRequestDto.setNoOfGuest(2);
 * bookingRequestDto.setCheckInDate("2020-06-25");
 * bookingRequestDto.setCheckOutDate("2020-06-26");
 * bookingRequestDto.setCheckInTime("08:00:02");
 * bookingRequestDto.setCheckOutTime("08:00:04");
 * bookingResponseDto.setBookingId(1); bookingResponseDto.setMessage("success");
 * 
 * 
 * 
 * }
 * 
 * @Test public void bookingDetails() { BookingDetails bookingdetails=new
 * BookingDetails() ; bookingdetails.setRoomId(1); bookingdetails.setUserId(1);
 * 
 * 
 * //given when(bookingdao.save(any(BookingDetails.class))).thenReturn(any(
 * BookingDetails.class));
 * 
 * //when bookingServiceImpl.bookingDetails(bookingRequestDto);
 * 
 * //then verify(bookingdao).save(any(BookingDetails.class));
 * 
 * }
 * 
 * @Test public void bookingDetails1() { BookingDetails bookingdetails=new
 * BookingDetails() ; bookingdetails.setRoomId(1); bookingdetails.setUserId(1);
 * bookingdetails.setNoOfGuest(2);
 * 
 * //BookingRequestDto bookingresponse=new BookingResponseDto();
 * 
 * 
 * 
 * 
 * 
 * Mockito.when(bookingdao.findAllByRoomId(1)).thenReturn(null);
 * BookingResponseDto resUser =
 * bookingServiceImpl.bookingDetails(bookingRequestDto);
 * Assert.notNull(resUser); }
 * 
 * 
 * 
 * }
 */