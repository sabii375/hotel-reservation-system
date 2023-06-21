package com.hotelReservation.HotelReservation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class HotelDetailsRequestDto {

    private String roomType;



    private Integer rate;


    private Integer availableRooms;

    private Integer numberOfBeds;

    private Integer numberOfBath;

    private Boolean wifi;

    private String description;

}


