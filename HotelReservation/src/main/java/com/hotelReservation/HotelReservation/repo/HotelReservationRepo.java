package com.hotelReservation.HotelReservation.repo;

import com.hotelReservation.HotelReservation.entity.HotelReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelReservationRepo extends JpaRepository<HotelReservation, Integer> {
}
