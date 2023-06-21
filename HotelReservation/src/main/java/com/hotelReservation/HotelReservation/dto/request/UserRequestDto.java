package com.hotelReservation.HotelReservation.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String fullName;


    private String userName;

    private String email;

    private String password;

    private String address;

}
