package com.hotelReservation.HotelReservation.repo;

import com.hotelReservation.HotelReservation.entity.HotelDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelDetailsRepo extends JpaRepository< HotelDetails, Integer>
{
    HotelDetails findByRoomType(String roomType);
}
