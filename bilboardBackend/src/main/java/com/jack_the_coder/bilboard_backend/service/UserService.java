package com.jack_the_coder.bilboard_backend.service;

import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This class enables communication between controller and repository
 * @since 10.12.2021
 */
public interface UserService extends UserDetailsService {

    UserDto createUser ( UserDto user );

    UserDto getUserByEmail ( String email );

    UserDto getUserById ( long id );

    List<UserDto> searchUser ( String name , String type );

    Boolean verifyEmailToken ( String token );

    Boolean requestPasswordReset ( String email );

    Boolean resetPassword ( String token , String password );

    Boolean changeGeStatus ( long userId , boolean geStatus );

    Boolean changeNameSurname ( long userId , String name , String surname );

    Boolean changeId ( long userId , String id );

    Boolean changePhoto ( long userId , MultipartFile photo );

    @Override
    UserDetails loadUserByUsername ( String s ) throws UsernameNotFoundException;
}
