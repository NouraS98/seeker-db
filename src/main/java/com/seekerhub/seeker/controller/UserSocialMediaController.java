package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.dto.user.UserSocialMediaDto;
import com.seekerhub.seeker.service.UserSocialMedia.UserSociaMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/userSocialMedia")
public class UserSocialMediaController {


    @Autowired
    private UserSociaMediaService userSociaMediaService;

    @PostMapping("add-accounts")
    public ResponseEntity create(@RequestBody UserSocialMediaDto userSocialMediaDto) {
        return ResponseEntity.ok(userSociaMediaService.save(userSocialMediaDto));
    }

    @GetMapping("find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(userSociaMediaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(userSociaMediaService.findById(id));
    }

//    @PostMapping("twitter/{twitter}/{user}")
//    public void setTwitter(@PathVariable String twitter, @RequestBody UserDto user){
//        userSociaMediaService.setTwitter(twitter, user);
//    }

}
