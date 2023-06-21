package com.hotelReservation.HotelReservation.repo;

import com.hotelReservation.HotelReservation.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
}
