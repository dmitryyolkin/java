package com.yolkin.springbootdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * By creating this class we ask Spring Boot to skip Basic Spring Security Configuration
 * and ask to use our own Security config
 */

@Profile("production")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(username ->
                        readerRepository
                                .findById(username)
                                .orElseThrow(() -> new UsernameNotFoundException("User is not found" + username)));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // require Reader access
        http
                .authorizeRequests()
                .antMatchers("/").access("hasRole('READER')")
                .antMatchers("/**").permitAll()

                .and()

                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true");

    }
}