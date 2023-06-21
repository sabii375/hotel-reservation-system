package com.hotelReservation.HotelReservation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor

public class AdminController {


    @GetMapping("/admin-site")
    public String getAdminSite(){
        return "admin/admin";
    }
}
