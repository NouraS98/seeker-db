package com.seekerhub.seeker.service.account;

import com.seekerhub.seeker.dto.login.LoginDto;
import com.seekerhub.seeker.dto.user.UserDto;

public interface AccountService {

    String login(LoginDto loginDto);
}
