package com.seekerhub.seeker.service.security.token;

import org.springframework.security.core.userdetails.UserDetails;

public interface TokenService {

    String getUsernameFromToken(String token);

    String generateToken(UserDetails userDetails);

    Boolean validateToken(String token, UserDetails userDetails);

    void invalidateToken(String token);

    String refreshToken(String token);
}
