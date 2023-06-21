package com.hotelReservation.HotelReservation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
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
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String reservedDate;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String arrivalDate;


//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String departureDate;

    @Column(length = 20)
    private Integer numberOfAdults;

    @Column(length = 20)
    private Integer numberOfKida;

    @Column(length = 20)
    private Integer numberOfRoom;

    @ManyToOne
    @JoinColumn(name="room_id")
    private HotelDetails room;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;



}
