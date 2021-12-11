package com.jack_the_coder.bilboard_backend.serviceImplementation;

import com.jack_the_coder.bilboard_backend.exception.UserServiceException;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import com.jack_the_coder.bilboard_backend.io.repository.UserRepository;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import com.jack_the_coder.bilboard_backend.util.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser ( UserDto user ) {
        if ( userRepository.findByEmail( user.getEmail() ) != null ) {
            throw new UserServiceException( "Record already exists with this email" );
        }
        if ( userRepository.findByBilkentId( user.getBilkentId() ) != null ) {
            throw new UserServiceException( "This Bilkent ID is in usage, Please contact with admin!" );
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties( user , userEntity );


        userEntity.setPassword( bCryptPasswordEncoder.encode( user.getPassword() ) );
        userEntity.setEmailConfirmationToken( utils.generateEmailVerificationToken( userEntity.getBilkentId() ) );
        userEntity.setEmailConfirmation( false );
        /*
        if ( !emailService.sendEmail( user.getEmail() , "You can confirm by using this link: \n" +
                "https://localifyapp.com/confirmation/" + userEntity.getEmailConfirmationToken() , "Confirmation" ) ) {
            throw new RuntimeException();
        }
         */
        UserEntity storedUser = userRepository.save( userEntity );
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties( storedUser , returnValue );

        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername ( String s ) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail( s );

        if ( userEntity == null )
            throw new UsernameNotFoundException( s );

        return new User( userEntity.getEmail() , userEntity.getPassword() ,
                userEntity.isEmailConfirmation() ,
                true , true ,
                true , new ArrayList<>() );
    }

    @Override
    public UserDto getUserByEmail ( String email ) {
        UserEntity userEntity = userRepository.findByEmail( email );



        if ( userEntity == null )
            throw new UsernameNotFoundException( email );
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties( userEntity , returnValue );

        return returnValue;
    }
}

