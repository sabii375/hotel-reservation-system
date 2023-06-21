package com.hotelReservation.HotelReservation.dto.response;

import com.hotelReservation.HotelReservation.entity.HotelDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class HotelDetailsResponseDto {
    private Integer detailId;
    private String roomType;
    private Integer rate;
    private Integer availableRooms;
    private String description;
    private Integer numberOfBath;
    private Integer numberOfBeds;
    private Boolean wifi;

    public HotelDetailsResponseDto(HotelDetails saveInfo) {
        this.detailId= saveInfo.getDetailId();
        this.roomType = saveInfo.getRoomType();
        this.rate= saveInfo.getRate();
        this.wifi=saveInfo.getWifi();
        this.numberOfBath=saveInfo.getNumberOfBath();
        this.numberOfBeds= saveInfo.getNumberOfBath();
        this.description= saveInfo.getDescription();
        this.availableRooms = saveInfo.getAvailableRooms();
    }
}
