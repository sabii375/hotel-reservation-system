package com.hotelReservation.HotelReservation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class HotelDetailsRequestDto {
    private String bedType;
    private Integer rate;
    private Integer rooms;

}


