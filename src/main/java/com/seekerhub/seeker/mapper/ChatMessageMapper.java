package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.Chat.ChatMessageDto;
import com.seekerhub.seeker.entity.ChatMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatMessageMapper extends BaseMapper<ChatMessage, ChatMessageDto>{
}
