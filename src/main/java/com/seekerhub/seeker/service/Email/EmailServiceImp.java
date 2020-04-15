package com.seekerhub.seeker.service.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImp implements EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendEmail(SimpleMailMessage message) {
        javaMailSender.send(message);
    }
}
