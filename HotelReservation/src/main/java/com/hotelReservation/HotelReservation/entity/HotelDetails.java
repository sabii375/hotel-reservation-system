package com.hotelReservation.HotelReservation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HotelDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer detailId;

    @Column(length = 30)
    private String bedType;

    @Column(length = 10)
    private Integer rate;

    @Column(length = 30)
    private Integer rooms;

    private Integer numberOfBeds;

    private Integer numberOfBath;

    private Boolean wifi;


}
