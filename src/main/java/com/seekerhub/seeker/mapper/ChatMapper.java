package com.seekerhub.seeker.mapper;


import com.seekerhub.seeker.dto.Chat.ChatDto;
import com.seekerhub.seeker.entity.Chat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatMapper extends BaseMapper<Chat, ChatDto>{

}


