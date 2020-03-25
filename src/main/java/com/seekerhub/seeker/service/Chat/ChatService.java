package com.seekerhub.seeker.service.Chat;

import com.seekerhub.seeker.dto.Chat.ChatDto;
import com.seekerhub.seeker.dto.user.UserDto;

import java.util.List;

public interface ChatService {
    ChatDto save(ChatDto chatDto);
    List<ChatDto> findAll();
    ChatDto findById(long id);
    List<ChatDto> findByFirstUserOrLastUser(Long user_id);
    ChatDto findByFirstUserAndLastUser(Long user1_id , Long user2_id);
}
