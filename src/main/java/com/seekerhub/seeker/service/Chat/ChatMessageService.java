package com.seekerhub.seeker.service.Chat;

import com.seekerhub.seeker.dto.Chat.ChatDto;
import com.seekerhub.seeker.dto.Chat.ChatMessageDto;

import java.util.List;

public interface ChatMessageService {
    ChatMessageDto save(ChatMessageDto chatMessageDto);
    List<ChatMessageDto> findAll();
    ChatMessageDto findById(long id);

}
