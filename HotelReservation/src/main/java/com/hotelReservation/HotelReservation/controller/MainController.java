package com.hotelReservation.HotelReservation.controller;

import com.hotelReservation.HotelReservation.dto.request.ContactRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor

public class MainController {

    @GetMapping("/")
    public String getIndex(){
        return "main/index";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "main/about";
    }

    @GetMapping("/booking")
    public String getBooking(){
        return "main/booking";
    }

    @GetMapping("/contact")
    public String getContact(Model model){
        model.addAttribute("dto", new ContactRequestDto());
        return "main/contact";
    }

    @GetMapping("/room")
    public String getRoom(){
        return "main/room";
    }

    @GetMapping("/service")
    public String getService(){
        return "main/service";
    }

    @GetMapping("/team")
    public String getTeam(){
        return "main/team";
    }

    @GetMapping("/testimonial")
    public  String getTestimonial(){
        return "main/testimonial";
    }


}
