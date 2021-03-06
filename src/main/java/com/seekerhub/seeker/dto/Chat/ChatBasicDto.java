package com.seekerhub.seeker.dto.Chat;

import com.seekerhub.seeker.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatBasicDto {
    private long id;

    private UserDto firstUser;
    private UserDto secondUser;
}
