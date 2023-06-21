package com.hotelReservation.HotelReservation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class HotelReservationRequestDto {

    private String reserveDate;
    private String arrivalDate;
    private String departureDate;
    private Integer numberOfAdults;
    private Integer numberOfKida;

    private Integer numberOfRoom;

}

