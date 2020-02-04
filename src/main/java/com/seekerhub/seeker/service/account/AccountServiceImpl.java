package com.seekerhub.seeker.service.account;

import com.seekerhub.seeker.dto.login.LoginDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.dto.user.UserForRegisterDto;
import com.seekerhub.seeker.service.security.token.TokenService;
import com.seekerhub.seeker.service.security.user.SecurityService;
import com.seekerhub.seeker.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private UserService userService;
    @Autowired private UserDetailsService userDetailsService;
    @Autowired private TokenService tokenService;
    @Autowired private SecurityService securityService;

    @Override
    public UserDto register(UserForRegisterDto userForRegisterDto) {
        return userService.register(userForRegisterDto);
    }

    @Override
    public String login(LoginDto loginDto) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getEmail());
        final String token = tokenService.generateToken(userDetails);
        return token;
    }
}
