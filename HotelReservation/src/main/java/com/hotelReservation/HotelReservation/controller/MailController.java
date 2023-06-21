package com.hotelReservation.HotelReservation.controller;

import com.hotelReservation.HotelReservation.dto.request.ContactRequestDto;
import com.hotelReservation.HotelReservation.service.ContactService;
import com.hotelReservation.HotelReservation.service.implementation.EmailServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailController {
    private final EmailServiceImplementation emailServiceImplementation;
    private final ContactService contactService;

    public MailController(EmailServiceImplementation emailServiceImplementation, ContactService contactService) {
        this.emailServiceImplementation = emailServiceImplementation;
        this.contactService = contactService;
    }

    @PostMapping("/contact-submit")

    public String handelingContactForm(@ModelAttribute ContactRequestDto dto){
        contactService.saveMessage(dto);

        String to = dto.getEmail();
        System.out.println(to); //debug line
        String subject = "Thank you for your message";
        String body = "Dear Customer,\n\nThank you for contacting us. We have received your message and will get back to you soon.\n\nBest regards,\nThe Support Team";
        emailServiceImplementation.sendMail(to, subject, body) ;

        return "redirect:/contact";

     }

     @PostMapping("/newsletter-submit")
     public String handleNewsletter(@ModelAttribute ContactRequestDto dto) {
         contactService.saveMessage(dto);

         String to = dto.getEmail();
         String subject = "Thank you for your subscription";
         String body = "Dear Customer. \n\n Thank you for subscribing our newsletter.";
         emailServiceImplementation.sendMail(to, subject, body);

         return ("redirect:/");

     }

}
