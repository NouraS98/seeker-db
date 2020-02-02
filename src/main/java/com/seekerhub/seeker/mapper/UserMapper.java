package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {

}
