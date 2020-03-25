package com.seekerhub.seeker.dto.Chat;

import com.seekerhub.seeker.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class ChatDto {
    private long id;
    private UserDto firstUser;
    private UserDto secondUser;
    private List<ChatMessageDto> chatMessages = new ArrayList<>();


}
