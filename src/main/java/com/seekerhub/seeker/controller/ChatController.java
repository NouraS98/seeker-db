package com.seekerhub.seeker.controller;

import com.seekerhub.seeker.dto.Chat.ChatDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.service.Chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping
    public ResponseEntity create(@RequestBody ChatDto chatDto) {
        return ResponseEntity.ok(chatService.save(chatDto));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(chatService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(chatService.findById(id));
    }

    @GetMapping("user/{user_id}")
    public ResponseEntity findByfirstUserOrLastUser(@PathVariable Long user_id){
        return ResponseEntity.ok(chatService.findByFirstUserOrLastUser(user_id));
    }

}
