package com.seekerhub.seeker.controller;

import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity create(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    //هنا سويت كذا عشان هو يفهم اني ابي ابحث عن يوزرنيم لو ماسويت كذا مايدري انا ادور اي دي ولا يوزرنيم
    @GetMapping("username/{username}")
    public ResponseEntity findByUsername(@PathVariable String username){
       return ResponseEntity.ok(userService.findByUsername(username));
    }

    @GetMapping("email/{email}")
    public ResponseEntity findByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }
}
