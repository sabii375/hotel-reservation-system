package com.hotelReservation.HotelReservation.dto.response;


import com.hotelReservation.HotelReservation.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Integer id;
    private String fullName;



    private String username;

    private String email;

    private String password;

    private String address;

    private Integer phone;

    public UserResponseDto(User user){
        this.id = user.getId();
        this.fullName= user.getFullName();

        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.address = user.getPassword();
     }
}
