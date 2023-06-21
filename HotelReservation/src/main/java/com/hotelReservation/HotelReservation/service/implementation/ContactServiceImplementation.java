package com.hotelReservation.HotelReservation.service.implementation;

import com.hotelReservation.HotelReservation.dto.request.ContactRequestDto;
import com.hotelReservation.HotelReservation.entity.Contact;
import com.hotelReservation.HotelReservation.repo.ContactRepo;
import com.hotelReservation.HotelReservation.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImplementation implements ContactService {

    private final ContactRepo contactRepo;

    public ContactServiceImplementation(ContactRepo contactRepo) {

        this.contactRepo = contactRepo;
    }

    @Override
    public void saveMessage(ContactRequestDto dto) {
        Contact contact = new Contact();

        contact.setName(dto.getName());
        contact.setEmail(dto.getEmail());

        Contact saveContact = contactRepo.save(contact);

     }


}
