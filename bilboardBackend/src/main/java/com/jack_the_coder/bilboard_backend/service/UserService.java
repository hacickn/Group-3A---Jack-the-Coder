package com.jack_the_coder.bilboard_backend.service;

import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    UserDto createUser ( UserDto user );

    UserDto getUserByEmail ( String email );

    UserDto getUserById ( long id );

    boolean verifyEmailToken ( String token );

    boolean requestPasswordReset ( String email );

    boolean resetPassword ( String token , String password );

    @Override
    UserDetails loadUserByUsername ( String s ) throws UsernameNotFoundException;
}
