package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.Chat.ChatDto;
import com.seekerhub.seeker.dto.Chat.ChatMessageDto;
import com.seekerhub.seeker.service.Chat.ChatMessageService;
import com.seekerhub.seeker.service.Chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/chatMessage")
public class ChatMessageController {

    @Autowired
    ChatMessageService chatMessageService;

    @PostMapping
    public ResponseEntity create(@RequestBody ChatMessageDto chatMessageDto) {
        return ResponseEntity.ok(chatMessageService.save(chatMessageDto));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(chatMessageService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(chatMessageService.findById(id));
    }

}
