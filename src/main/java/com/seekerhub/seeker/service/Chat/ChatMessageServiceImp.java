package com.seekerhub.seeker.service.Chat;


import com.seekerhub.seeker.dto.Chat.ChatDto;
import com.seekerhub.seeker.dto.Chat.ChatMessageDto;
import com.seekerhub.seeker.entity.Chat;
import com.seekerhub.seeker.entity.ChatMessage;
import com.seekerhub.seeker.mapper.ChatMapper;
import com.seekerhub.seeker.mapper.ChatMessageMapper;
import com.seekerhub.seeker.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageServiceImp implements ChatMessageService {
    @Autowired
    ChatMessageRepository chatMessageRepository;

    @Autowired
    ChatMessageMapper chatMessageMapper;


    @Override
    public ChatMessageDto save(ChatMessageDto chatMessageDto) {
        ChatMessage chatMessage = chatMessageMapper.toEntity(chatMessageDto);
        ChatMessage chatToSave = chatMessageRepository.save(chatMessage);
        return chatMessageMapper.toDto(chatToSave);
    }

    @Override
    public List<ChatMessageDto> findAll() {
        return chatMessageMapper.toDtos(chatMessageRepository.findAll());
    }

    @Override
    public ChatMessageDto findById(long id) {
        return chatMessageMapper.toDto(chatMessageRepository.getOne(id));
    }
}
