package com.seekerhub.seeker.service.Chat;

import com.seekerhub.seeker.dto.Chat.ChatDto;
import com.seekerhub.seeker.entity.Chat;
import com.seekerhub.seeker.mapper.ChatMapper;
import com.seekerhub.seeker.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImp implements ChatService {

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    ChatMapper chatMapper;

    @Override
    public ChatDto save(ChatDto chatDto) {
        Chat chat = chatMapper.toEntity(chatDto);
        Chat chatToSave = chatRepository.save(chat);
        return chatMapper.toDto(chatToSave);
    }

    @Override
    public List<ChatDto> findAll() {
        return chatMapper.toDtos(chatRepository.findAll());
    }

    @Override
    public ChatDto findById(long id) {
        return chatMapper.toDto(chatRepository.getOne(id));
    }
}
