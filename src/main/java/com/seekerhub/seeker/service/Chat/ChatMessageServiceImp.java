package com.seekerhub.seeker.service.Chat;


import com.seekerhub.seeker.dto.Chat.ChatDto;
import com.seekerhub.seeker.dto.Chat.ChatMessageDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.entity.Chat;
import com.seekerhub.seeker.entity.ChatMessage;
import com.seekerhub.seeker.mapper.ChatMapper;
import com.seekerhub.seeker.mapper.ChatMessageMapper;
import com.seekerhub.seeker.repository.ChatMessageRepository;
import com.seekerhub.seeker.service.PushNotificationsService;
import com.seekerhub.seeker.service.user.UserService;
import com.seekerhub.seeker.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageServiceImp implements ChatMessageService {
    @Autowired
    ChatMessageRepository chatMessageRepository;

    @Autowired
    ChatMessageMapper chatMessageMapper;

    @Autowired
    PushNotificationsService pushNotificationsService;

    @Autowired
    ChatService chatService;

    @Autowired
    UserService userService;

    @Override
    public ChatMessageDto save(ChatMessageDto chatMessageDto) {
        ChatMessage chatMessage = chatMessageMapper.toEntity(chatMessageDto);
        ChatMessage chatToSave = chatMessageRepository.save(chatMessage);
        ChatDto chatDto = chatService.findById(chatMessageDto.getChat().getId());
        String token ="";
        Long user_id = Long.valueOf(0);
        if(chatDto.getFirstUser().getId()== chatMessage.getSender().getId()){
            user_id = chatDto.getSecondUser().getId();
        }else{
            user_id = chatDto.getFirstUser().getId();
        }
        UserDto userDto = userService.findById(user_id);
        token = userDto.getToken_id();

        pushNotificationsService.sendToAUser(chatMessageMapper.toDto(chatToSave) , token );
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
