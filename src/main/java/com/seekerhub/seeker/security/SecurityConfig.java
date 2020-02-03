package com.seekerhub.seeker.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/api/user/**").permitAll()
                .antMatchers("/api/employer/**").permitAll().antMatchers("/api/account/**").permitAll().antMatchers("/api/freelancer/**").permitAll()
                .antMatchers("/api/**").authenticated();
    }
}
