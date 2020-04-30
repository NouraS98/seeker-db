package com.seekerhub.seeker.service.account;

import com.seekerhub.seeker.dto.login.LoginDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.dto.user.UserForRegisterDto;
import com.seekerhub.seeker.entity.User;
import com.seekerhub.seeker.exception.ApiError;
import com.seekerhub.seeker.exception.GenericException;
import com.seekerhub.seeker.repository.UserRepository;
import com.seekerhub.seeker.security.PrivateKeyImpl;
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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private UserService userService;
    @Autowired private UserDetailsService userDetailsService;
    @Autowired private TokenService tokenService;
    @Autowired private SecurityService securityService;
    @Autowired private UserRepository userRepository;

    @Override
    public UserDto register(UserForRegisterDto userForRegisterDto) {

        return userService.register(userForRegisterDto);
    }

    @Override
    @Transactional
    public String login(LoginDto loginDto) {

        try {
            loginDto.setPassword(PrivateKeyImpl.decryptMessage(loginDto.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getEmail());
        if(userDetails!=null){
            UserDto user = userService.findByEmail(loginDto.getEmail());
            if(!user.isVerified()){
                throw new GenericException("Email is not verified");
            }
            User userToSave = userRepository.findByEmailIgnoreCase(loginDto.getEmail());
            userToSave.setLogin(true);
            userRepository.save(userToSave);
        }
        final String token = tokenService.generateToken(userDetails);
        return token;
    }

    @Override
    public UserDto registerAdmin(UserForRegisterDto userForRegisterDto) {
        return userService.registerAdmin(userForRegisterDto);
    }
}
