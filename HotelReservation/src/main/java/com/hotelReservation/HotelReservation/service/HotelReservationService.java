package com.hotelReservation.HotelReservation.service;

import com.hotelReservation.HotelReservation.dto.request.HotelReservationRequestDto;
import com.hotelReservation.HotelReservation.dto.response.HotelReservationResponseDto;
import com.hotelReservation.HotelReservation.entity.User;

import java.util.List;

public interface HotelReservationService {

    HotelReservationResponseDto savedata (HotelReservationRequestDto dto);

    HotelReservationResponseDto findByUsingId (Integer id);

    List<HotelReservationResponseDto> showAll();

    HotelReservationResponseDto updateByUsingId (Integer id, HotelReservationRequestDto dto);

    String deleteById(Integer id);
    void bindHotelWithReservation(Integer reservedId, Integer roomId, User foundUser);

}
