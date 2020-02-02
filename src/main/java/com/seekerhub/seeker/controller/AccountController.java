package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account")
public class AccountController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
     public ResponseEntity signup(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.register(userDto));
    }
}
