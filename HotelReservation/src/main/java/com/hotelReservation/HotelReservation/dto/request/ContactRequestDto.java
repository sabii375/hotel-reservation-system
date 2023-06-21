package com.hotelReservation.HotelReservation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ContactRequestDto {

    private String name;
    private String email;
    private String subject;
    private String message;

}
