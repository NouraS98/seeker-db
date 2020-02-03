package com.seekerhub.seeker.service.security.user;

public interface SecurityService {

    String findLoggedInEmail();

    void autoLogin(String username, String password);
}
