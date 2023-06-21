package com.hotelReservation.HotelReservation.controller;

import com.hotelReservation.HotelReservation.dto.request.ContactRequestDto;
import com.hotelReservation.HotelReservation.dto.request.HotelDetailsRequestDto;
import com.hotelReservation.HotelReservation.dto.request.HotelReservationRequestDto;
import com.hotelReservation.HotelReservation.dto.response.HotelReservationResponseDto;
import com.hotelReservation.HotelReservation.entity.HotelDetails;
import com.hotelReservation.HotelReservation.entity.User;
import com.hotelReservation.HotelReservation.repo.HotelDetailsRepo;
import com.hotelReservation.HotelReservation.repo.UserRepo;
import com.hotelReservation.HotelReservation.service.HotelDetailsService;
import com.hotelReservation.HotelReservation.service.HotelReservationService;
import com.hotelReservation.HotelReservation.service.implementation.EmailServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;

@Controller
@RequiredArgsConstructor

public class MainController {

    private final HotelDetailsService hotelDetailsService;
    private final HotelReservationService hotelReservationService;
    private final HotelDetailsRepo hotelDetailsRepo;
    private final UserRepo userRepo;
    private final EmailServiceImplementation emailServiceImplementation;

    @GetMapping("/")
    public String getIndex(){
        return "main/index";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "main/about";
    }

    @GetMapping("/booking")
    public String getBooking(Model model)
    {
        model.addAttribute("roomDetails",hotelDetailsService.showAll());
        model.addAttribute("detailsDto",new HotelDetailsRequestDto());
        model.addAttribute("dto" ,new HotelReservationRequestDto());
        return "main/booking";
    }
    @PostMapping("/save-booking")
    public String getBookingg(@ModelAttribute HotelDetailsRequestDto detailsDto, @ModelAttribute HotelReservationRequestDto reservedDto, BindingResult bindingResult){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        if (bindingResult.hasErrors()){
             return "redirect:/booking";
        }
        User foundUser = userRepo.getUserByUsername(username);


        HotelReservationResponseDto savedReserve = hotelReservationService.savedata(reservedDto);

        HotelDetails foundDetails = hotelDetailsRepo.findByRoomType(detailsDto.getRoomType());
        hotelReservationService.bindHotelWithReservation(savedReserve.getReserveNo(),foundDetails.getDetailId(),foundUser);

        //Sending the booking confirmatoin email
        String subject = "Booking Confirmation";
        String message = "Thank you for choosing to stay with us. "+
                "\n\nYour Reservtion Details: "+
                "\n Check-In Date: " + reservedDto.getArrivalDate()+
                "\n Check-Out Date: " + reservedDto.getDepartureDate()+
                "\n No of Adults: " + reservedDto.getNumberOfAdults()+
                "\n No of Child:" + reservedDto.getNumberOfKida()+
                "\n Room Type: " + detailsDto.getRoomType()+
                "\n\n Enjoy your stay.";
        emailServiceImplementation.sendMail(foundUser.getEmail(),subject, message);
        return "redirect:/";

    }


    @GetMapping("/contact")
    public String getContact(Model model){
        model.addAttribute("dto", new ContactRequestDto());
        return "main/contact";
    }

    @GetMapping("/room")
    public String getRoom(Model model){
        model.addAttribute("all", hotelDetailsService.showAll());
        model.addAttribute("dto", new HotelDetailsRequestDto());
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
