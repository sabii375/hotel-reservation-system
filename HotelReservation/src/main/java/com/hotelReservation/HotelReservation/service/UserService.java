package com.hotelReservation.HotelReservation.service;


import com.hotelReservation.HotelReservation.dto.request.UserRequestDto;
import com.hotelReservation.HotelReservation.dto.response.UserResponseDto;

public interface UserService {

      void saveUserToTable(UserRequestDto userRequestDto);
}
