package com.seekerhub.seeker.service.Email;


import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendEmail(SimpleMailMessage message);

}
