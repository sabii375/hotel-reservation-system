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
    private String bedType;
    private Integer rate;
    private Integer rooms;

    public HotelDetailsResponseDto(HotelDetails saveInfo) {
        this.detailId= saveInfo.getDetailId();
        this.bedType= saveInfo.getBedType();
        this.rate= saveInfo.getRate();
        this.rooms= saveInfo.getRooms();
    }
}
