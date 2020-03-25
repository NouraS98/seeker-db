package com.seekerhub.seeker.service.Chat;

import com.seekerhub.seeker.dto.Chat.ChatDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.entity.Chat;
import com.seekerhub.seeker.exception.GenericException;
import com.seekerhub.seeker.mapper.ChatMapper;
import com.seekerhub.seeker.mapper.UserMapper;
import com.seekerhub.seeker.repository.ChatRepository;
import com.seekerhub.seeker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ChatServiceImp implements ChatService {

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    ChatMapper chatMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

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

    @Override
    public List<ChatDto> findByFirstUserOrLastUser(Long user_id) {

        return chatMapper.toDtos(chatRepository.findByFirstUserIdOrSecondUserId(user_id,user_id));
    }

    @Override
    public ChatDto findByFirstUserAndLastUser(Long user1_id, Long user2_id) {
        ChatDto chatDto = chatMapper.toDto(chatRepository.findByFirstUserIdAndSecondUserId(user1_id,user2_id));

        if(chatDto == null)
            chatDto = chatMapper.toDto(chatRepository.findByFirstUserIdAndSecondUserId(user2_id, user1_id));

        if(chatDto == null){
            if (!userRepository.existsById(user1_id) || !userRepository.existsById(user2_id))
                throw new GenericException("Users was not found");

            UserDto user1 = userMapper.toDto(userRepository.getOne(user1_id));
            UserDto user2 = userMapper.toDto(userRepository.getOne(user2_id));
            chatDto = new ChatDto();
            chatDto.setFirstUser(user1);
            chatDto.setSecondUser(user2);
            return save(chatDto);
        }
        return  chatDto;
    }

}
