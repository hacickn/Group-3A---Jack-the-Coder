package com.jack_the_coder.bilboard_backend.serviceImplementation;

import com.jack_the_coder.bilboard_backend.exception.UserServiceException;
import com.jack_the_coder.bilboard_backend.io.entity.PasswordResetTokenEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import com.jack_the_coder.bilboard_backend.io.repository.PasswordResetTokenRepository;
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
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

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

    @Override
    public UserDto getUserById ( long id ) {
        Optional<UserEntity> userEntity = userRepository.findById( id );

        if ( userEntity.isPresent() ) {
            ModelMapper modelMapper = new ModelMapper();

            return modelMapper.map( userEntity.get() , UserDto.class );
        } else {
            throw new UsernameNotFoundException( "" + id );
        }
    }

    @Override
    public boolean verifyEmailToken ( String token ) {

        boolean returnValue = false;

        UserEntity userEntity = userRepository.findUserByEmailConfirmationToken( token );

        if ( userEntity != null ) {
            boolean hasTokenExpired = Utils.hasTokenExpired( token );
            if ( !hasTokenExpired ) {
                userEntity.setEmailConfirmationToken( null );
                userEntity.setEmailConfirmation( Boolean.TRUE );
                userRepository.save( userEntity );
                returnValue = true;
            }
        }

        return returnValue;
    }

    @Override
    public boolean requestPasswordReset ( String email ) {
        try {
            UserEntity userEntity = userRepository.findByEmail( email );

            if ( userEntity == null ) {
                return false;
            }

            String token = new Utils().generatePasswordResetToken( userEntity.getId() + "" );

            PasswordResetTokenEntity passwordResetTokenEntity = new PasswordResetTokenEntity();
            passwordResetTokenEntity.setToken( token );
            passwordResetTokenEntity.setUserDetails( userEntity );
            passwordResetTokenRepository.save( passwordResetTokenEntity );
            /*
            emailService.sendEmail( userEntity.getEmail() ,
                    "You can reset your password by using this link: " + "\n https://localifyapp.com/resetPassword/"
                            + token , "Reset Password" );
             */

            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    @Override
    public boolean resetPassword ( String token , String password ) {
        boolean returnValue = false;

        if ( Utils.hasTokenExpired( token ) ) {
            return false;
        }

        PasswordResetTokenEntity passwordResetTokenEntity = passwordResetTokenRepository.findByToken( token );

        if ( passwordResetTokenEntity == null ) {
            return false;
        }

        //new password
        String encodedPassword = bCryptPasswordEncoder.encode( password );

        //update old record in database
        UserEntity userEntity = passwordResetTokenEntity.getUserDetails();
        userEntity.setPassword( encodedPassword );
        UserEntity savedUserEntity = userRepository.save( userEntity );

        // verification of new password
        if ( savedUserEntity.getPassword().equalsIgnoreCase( encodedPassword ) ) {
            returnValue = true;
        }

        // delete resetToken
        passwordResetTokenRepository.delete( passwordResetTokenEntity );

        return returnValue;
    }
}

