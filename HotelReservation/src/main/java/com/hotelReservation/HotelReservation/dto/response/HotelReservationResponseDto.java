package com.hotelReservation.HotelReservation.dto.response;


import com.hotelReservation.HotelReservation.entity.HotelReservation;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class HotelReservationResponseDto {

    private Integer reserveNo;
    private String reserveDate;
    private String arrivalDate;
    private String departureDate;
    private Integer noOfAdults;
    private Integer noOfKids;
    private Integer numberOfRoom;

    public HotelReservationResponseDto(HotelReservation savedInfo) {
        this.reserveNo = savedInfo.getReserveNo();
        this.arrivalDate = savedInfo.getArrivalDate();

        this.reserveDate =  savedInfo.getReservedDate();
        this.noOfAdults = savedInfo.getNumberOfAdults();
        this.noOfKids = savedInfo.getNumberOfKida();

        this.numberOfRoom = savedInfo.getNumberOfRoom();

        this.departureDate =  savedInfo.getDepartureDate();

    }
}
