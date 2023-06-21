package com.hotelReservation.HotelReservation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HotelReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reserveNo;

    @Column(length = 25)
    private Date reservedDate;

    @Column(length = 20)
    private Date arrivalDate;

    @Column(length = 20)
    private Date departureDate;

    @Column(length = 20)
    private Integer numberOfAdults;

    @Column(length = 20)
    private Integer numberOfKida;

    @Column(length = 20)
    private Integer numberOfRoom;



}
