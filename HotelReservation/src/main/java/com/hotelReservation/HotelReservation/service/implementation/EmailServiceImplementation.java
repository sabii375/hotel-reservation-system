package com.hotelReservation.HotelReservation.service.implementation;

import com.hotelReservation.HotelReservation.repo.ContactRepo;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImplementation {

     private final JavaMailSender javaMailSender;

    public EmailServiceImplementation(ContactRepo contactRepo, JavaMailSender javaMailSender) {
         this.javaMailSender = javaMailSender;
    }

    public void sendMail( String to, String subject, String body){
//        SimpleMailMessage sendEmail = new SimpleMailMessage();
//
//        sendEmail.setTo(to);
//        sendEmail.setSubject(subject);
//        sendEmail.setText(body);
//        javaMailSender.send(sendEmail);


    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);

        try{
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body);
        helper.setFrom("beeplaw21@gmail.com");
        javaMailSender.send(message);

    }catch (Exception e){

    }}
}
