package com.seekerhub.seeker.service.account;

import com.seekerhub.seeker.dto.login.LoginDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.dto.user.UserForRegisterDto;

public interface AccountService {

    UserDto register(UserForRegisterDto userForRegisterDto);

    String login(LoginDto loginDto);

}
