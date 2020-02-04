package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.login.LoginDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.dto.user.UserForRegisterDto;
import com.seekerhub.seeker.service.account.AccountService;
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

    @Autowired
    private AccountService accountService;

    @PostMapping("register")
     public ResponseEntity signUp(@RequestBody UserForRegisterDto userDto){
        return ResponseEntity.ok(userService.register(userDto));
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(accountService.login(loginDto));
    }
}
