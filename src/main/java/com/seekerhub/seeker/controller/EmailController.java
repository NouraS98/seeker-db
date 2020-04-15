package com.seekerhub.seeker.controller;

import com.seekerhub.seeker.service.Email.EmailService;
import com.seekerhub.seeker.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/email")
public class EmailController {
    @Autowired
    UserService userService;

    @GetMapping
    public void sendEmail(){
     userService.sendEmailVerificationToken("nouraalsabr");

    }
}
