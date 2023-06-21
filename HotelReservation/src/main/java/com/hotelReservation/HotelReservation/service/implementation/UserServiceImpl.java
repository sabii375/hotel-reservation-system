package com.hotelReservation.HotelReservation.service.implementation;


import com.hotelReservation.HotelReservation.dto.request.UserRequestDto;
import com.hotelReservation.HotelReservation.dto.response.UserResponseDto;
import com.hotelReservation.HotelReservation.entity.User;
import com.hotelReservation.HotelReservation.repo.RoleRepo;
import com.hotelReservation.HotelReservation.repo.UserRepo;
import com.hotelReservation.HotelReservation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;


    @Override
    public void saveUserToTable(UserRequestDto dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User newUser = new User();

        newUser.setFullName(dto.getFullName());
        newUser.setUsername(dto.getUserName());
        newUser.setPassword(encoder.encode(dto.getPassword()));
        newUser.setEmail(dto.getEmail());
        newUser.setAddress(dto.getAddress());

        newUser.setRoles(roleRepo.getUserRole("USER"));

        try{
            User savedUser = userRepo.save(newUser);

//            return new UserResponseDto(savedUser);
        }catch (PersistenceException ex){
            System.out.println("Not unique username. ");
        }
    }
}
