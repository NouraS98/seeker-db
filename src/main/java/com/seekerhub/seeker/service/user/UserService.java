package com.seekerhub.seeker.service.user;

import com.seekerhub.seeker.dto.user.UserDto;

import java.util.List;

public interface UserService<list> {
    UserDto save(UserDto userdto);
    List<UserDto> findAll();
    UserDto findById(long id);
    UserDto findByUsername(String username);
    UserDto findByEmail (String email);
    UserDto register(UserDto userDto);
}
