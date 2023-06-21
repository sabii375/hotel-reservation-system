package com.hotelReservation.HotelReservation.controller;

import com.hotelReservation.HotelReservation.dto.request.UserRequestDto;
import com.hotelReservation.HotelReservation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class RegisterController {

    private final UserService userService;

    @GetMapping("/login")
    public String getLogInPage(){
        return "Login/Login";
    }

    @GetMapping("/sign-up")
    public String getSignUp(Model model){
        model.addAttribute("dto", new UserRequestDto());
        return "Login/signUp";
    }

    @PostMapping("/sign-up")
    public String register(Model model, @ModelAttribute UserRequestDto dto){
        userService.saveUserToTable(dto);
        return "redirect:/login";
    }





}
