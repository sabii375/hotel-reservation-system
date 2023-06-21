package com.hotelReservation.HotelReservation.service.implementation;

import com.hotelReservation.HotelReservation.dto.request.HotelDetailsRequestDto;
import com.hotelReservation.HotelReservation.dto.response.HotelDetailsResponseDto;
import com.hotelReservation.HotelReservation.entity.HotelDetails;
import com.hotelReservation.HotelReservation.repo.HotelDetailsRepo;
import com.hotelReservation.HotelReservation.service.HotelDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HotelDetailsServiceImplementation implements HotelDetailsService {

    private final HotelDetailsRepo hotelDetailsRepo;

    public HotelDetailsServiceImplementation(HotelDetailsRepo hotelDetailsRepo) {
        this.hotelDetailsRepo = hotelDetailsRepo;
    }



    @Override
    public HotelDetailsResponseDto saveAll(HotelDetailsRequestDto dto) {

        HotelDetails hotelDetails = new HotelDetails();
        hotelDetails.setWifi(dto.getWifi());
        hotelDetails.setDescription(dto.getDescription());
        hotelDetails.setNumberOfBeds(dto.getNumberOfBeds());
        hotelDetails.setAvailableRooms(dto.getAvailableRooms());
        hotelDetails.setRate(dto.getRate());
        hotelDetails.setNumberOfBath(dto.getNumberOfBath());
        hotelDetails.setRoomType(dto.getRoomType());

        HotelDetails saveInfo = hotelDetailsRepo.save(hotelDetails);

        return new HotelDetailsResponseDto(saveInfo);

    }

    @Override
    public HotelDetailsResponseDto FindUsingId(Integer id) {
        HotelDetails findUsingId = hotelDetailsRepo.findById(id).get();

        return new HotelDetailsResponseDto(findUsingId);
    }

    @Override
    public List<HotelDetailsResponseDto> showAll() {
        List<HotelDetailsResponseDto> showingAllData = new ArrayList<>();

        List<HotelDetails> ReadingAllData = hotelDetailsRepo.findAll();

        for (HotelDetails each: ReadingAllData) {
            HotelDetailsResponseDto savelAllData = new HotelDetailsResponseDto(each);
            showingAllData.add(savelAllData);
        }
        return showingAllData;
    }

    @Override
    public HotelDetailsResponseDto updateInfo(Integer id, HotelDetailsRequestDto dto) {
         HotelDetails searchingById = hotelDetailsRepo.findById(id).get();

         searchingById.setAvailableRooms(dto.getAvailableRooms());
         searchingById.setRate(dto.getRate());
         searchingById.setRoomType(dto.getRoomType());

         HotelDetails savedData = hotelDetailsRepo.save(searchingById);
         return new HotelDetailsResponseDto(savedData);

    }

    @Override
    public String deleteById(Integer id) {
        hotelDetailsRepo.deleteById(id);
        return"Deleted";

    }
}
