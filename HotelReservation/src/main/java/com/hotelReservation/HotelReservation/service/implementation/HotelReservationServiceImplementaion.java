package com.hotelReservation.HotelReservation.service.implementation;

import com.hotelReservation.HotelReservation.dto.request.HotelReservationRequestDto;
import com.hotelReservation.HotelReservation.dto.response.HotelDetailsResponseDto;
import com.hotelReservation.HotelReservation.dto.response.HotelReservationResponseDto;
import com.hotelReservation.HotelReservation.entity.HotelDetails;
import com.hotelReservation.HotelReservation.entity.HotelReservation;
import com.hotelReservation.HotelReservation.entity.User;
import com.hotelReservation.HotelReservation.repo.HotelDetailsRepo;
import com.hotelReservation.HotelReservation.repo.HotelReservationRepo;
import com.hotelReservation.HotelReservation.service.HotelReservationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HotelReservationServiceImplementaion implements HotelReservationService {

    private final HotelReservationRepo hotelReservationRepo;

    private final HotelDetailsRepo hotelDetailsRepo;

    public HotelReservationServiceImplementaion(HotelReservationRepo hotelReservationRepo, HotelDetailsRepo hotelDetailsRepo) {
        this.hotelReservationRepo = hotelReservationRepo;
        this.hotelDetailsRepo = hotelDetailsRepo;
    }

    @Override
    public HotelReservationResponseDto savedata(HotelReservationRequestDto dto) {
        HotelReservation saveInfo = new HotelReservation();
        saveInfo.setArrivalDate(dto.getArrivalDate());
        saveInfo.setReservedDate(dto.getReserveDate());
        saveInfo.setNumberOfRoom(dto.getNumberOfRoom());
        saveInfo.setNumberOfAdults(dto.getNumberOfAdults());
        saveInfo.setNumberOfKida(dto.getNumberOfKida());
        saveInfo.setDepartureDate(dto.getDepartureDate());



        HotelReservation savedInfo = hotelReservationRepo.save(saveInfo);
        return new HotelReservationResponseDto(savedInfo);


    }
    public void bindHotelWithReservation(Integer reservedId, Integer roomId, User foundUser){
        HotelReservation foundReserved = hotelReservationRepo.findById(reservedId).get();
        HotelDetails foundRoom = hotelDetailsRepo.findById(roomId).get();
        foundReserved.setRoom(foundRoom);
        foundReserved.setUser(foundUser);
        HotelReservation newSaved = hotelReservationRepo.save(foundReserved);




    }



    @Override
    public HotelReservationResponseDto findByUsingId(Integer id) {
         HotelReservation findingUsingId = hotelReservationRepo.findById(id).get();

         return new HotelReservationResponseDto(findingUsingId);
    }

    @Override
    public List<HotelReservationResponseDto> showAll() {
        List<HotelReservationResponseDto> showingAll = new ArrayList<>();

        List<HotelReservation> findAll = hotelReservationRepo.findAll();

        for (HotelReservation each : findAll){
            HotelReservationResponseDto saving = new HotelReservationResponseDto(each);
            showingAll.add(saving);
        }
        return showingAll;
    }

    @Override
    public HotelReservationResponseDto updateByUsingId(Integer id, HotelReservationRequestDto dto) {
        HotelReservation findingById = hotelReservationRepo.findById(id).get();

        findingById.setDepartureDate(dto.getDepartureDate());

        findingById.setArrivalDate(dto.getArrivalDate());
        findingById.setReservedDate(dto.getReserveDate());

        findingById.setNumberOfAdults(dto.getNumberOfAdults());
        findingById.setNumberOfKida(dto.getNumberOfKida());

       return new HotelReservationResponseDto(findingById);

    }

    @Override
    public String deleteById(Integer id) {
        hotelReservationRepo.deleteById(id);
        return "Deleted0";
    }


}
