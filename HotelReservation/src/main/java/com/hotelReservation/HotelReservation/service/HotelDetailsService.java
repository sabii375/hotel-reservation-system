package com.hotelReservation.HotelReservation.service;

import com.hotelReservation.HotelReservation.dto.request.HotelDetailsRequestDto;
import com.hotelReservation.HotelReservation.dto.response.HotelDetailsResponseDto;

import java.util.List;

public interface HotelDetailsService {

    HotelDetailsResponseDto saveAll (HotelDetailsRequestDto dto);

    HotelDetailsResponseDto FindUsingId (Integer id);

    List<HotelDetailsResponseDto> showAll();

    HotelDetailsResponseDto updateInfo (Integer id, HotelDetailsRequestDto dto);

    String deleteById (Integer id);


}
