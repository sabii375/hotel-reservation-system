package com.hotelReservation.HotelReservation.service;

import com.hotelReservation.HotelReservation.dto.request.ContactRequestDto;

public interface ContactService {

    void saveMessage(ContactRequestDto dto);
}
