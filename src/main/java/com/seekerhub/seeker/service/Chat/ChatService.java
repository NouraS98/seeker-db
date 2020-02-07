package com.seekerhub.seeker.service.Chat;

import com.seekerhub.seeker.dto.Chat.ChatDto;

import java.util.List;

public interface ChatService {
    ChatDto save(ChatDto chatDto);
    List<ChatDto> findAll();
    ChatDto findById(long id);
}
