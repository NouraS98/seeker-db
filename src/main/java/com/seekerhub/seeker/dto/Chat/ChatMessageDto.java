package com.seekerhub.seeker.dto.Chat;

import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.entity.Chat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageDto {
    private long id;
    private LocalDateTime createdAt;
    private String message;
    private UserDto sender;
    private ChatBasicDto chat;
}
