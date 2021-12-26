package com.jack_the_coder.bilboard_backend.serviceImplementation;

import com.jack_the_coder.bilboard_backend.exception.UserServiceException;
import com.jack_the_coder.bilboard_backend.io.entity.PasswordResetTokenEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import com.jack_the_coder.bilboard_backend.io.repository.PasswordResetTokenRepository;
import com.jack_the_coder.bilboard_backend.io.repository.UserRepository;
import com.jack_the_coder.bilboard_backend.service.EmailService;
import com.jack_the_coder.bilboard_backend.service.StorageService;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    StorageService storageService;

    @Autowired
    EmailService emailService;

    /**
     * Method for creating a user
     * @param user is a UserDto
     * @return UserDto
     * @apiNote Method for creating a user
     */
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
        userEntity.setPhoto( "users/default.png" );


        if ( !emailService.sendEmail( user.getEmail() , "You can confirm by using this link: \n" +
                "http://localhost:3000/confirmation/" + userEntity.getEmailConfirmationToken() , "Confirmation" ) ) {
            throw new RuntimeException();
        }

        UserEntity storedUser = userRepository.save( userEntity );
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties( storedUser , returnValue );

        return returnValue;
    }

    /**
     * Method for loading a user by its name
     * @param s is a String
     * @return UserDetails
     * @apiNote Method for loading a user by its name
     */
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

    /**
     * Method for getting a user by its email
     * @param email is a String
     * @return UserDto
     * @apiNote Method for getting a user by its email
     */
    @Override
    public UserDto getUserByEmail ( String email ) {
        UserEntity userEntity = userRepository.findByEmail( email );


        if ( userEntity == null )
            throw new UsernameNotFoundException( email );
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties( userEntity , returnValue );

        return returnValue;
    }

    /**
     * Method for getting a user by its id
     * @param id is a String
     * @return UserDto
     * @apiNote Method for getting a user by its id
     */
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

    /**
     * Method for searching a user
     * @param name is a String
     * @param type is a String
     * @return List<UserDto>
     * @apiNote Method for searching a user
     */
    @Override
    public List<UserDto> searchUser ( String name , String type ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<UserDto> userDtoList = new ArrayList<>();

            userRepository.findByNameContainsAndType( name , UserEntity.UserTypes.valueOf( type ) )
                    .forEach( userEntity -> {
                        userDtoList.add( modelMapper.map( userEntity , UserDto.class ) );
                    } );
            return userDtoList;
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
        }
    }

    /**
     * Method for verifying email token
     * @param token is a String
     * @return Boolean
     * @apiNote Method for verifying email token
     */
    @Override
    public Boolean verifyEmailToken ( String token ) {

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

    /**
     * Method for requesting password reset
     * @param email is a String
     * @return Boolean
     * @apiNote Method for requesting password reset
     */
    @Override
    public Boolean requestPasswordReset ( String email ) {
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

            emailService.sendEmail( userEntity.getEmail() ,
                    "You can reset your password by using this link: " + "\n http://localhost:3000/resetPassword/"
                            + token , "Reset Password" );


            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    /**
     * Method for reseting password
     * @param token is a String
     * @param password is a String
     * @return Boolean
     * @apiNote Method for reseting password
     */
    @Override
    public Boolean resetPassword ( String token , String password ) {
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

    /**
     * Method for changing GE status
     * @param userId is a long
     * @param geStatus is a boolean
     * @return Boolean
     * @apiNote Method for changing GE status
     */
    @Override
    public Boolean changeGeStatus ( long userId , boolean geStatus ) {
        try {
            Optional<UserEntity> optionalUserEntity = userRepository.findById( userId );

            if ( optionalUserEntity.isPresent() ) {
                optionalUserEntity.get().setGeTaken( geStatus );
                userRepository.save( optionalUserEntity.get() );
                return true;
            } else {
                throw new UserServiceException( "User is not found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    /**
     * Method for changing name and surname
     * @param userId is a long
     * @param name is a String
     * @param surname is a String
     * @return Boolean
     * @apiNote Method for changing name and surname
     */
    @Override
    public Boolean changeNameSurname ( long userId , String name , String surname ) {
        try {
            Optional<UserEntity> optionalUserEntity = userRepository.findById( userId );

            if ( optionalUserEntity.isPresent() ) {
                optionalUserEntity.get().setName( name );
                optionalUserEntity.get().setSurname( surname );
                userRepository.save( optionalUserEntity.get() );
                return true;
            } else {
                throw new UserServiceException( "User is not found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    /**
     * Method for changing id
     * @param userId is a long
     * @param id is a String
     * @return Boolean
     * @apiNote Method for changing id
     */
    @Override
    public Boolean changeId ( long userId , String id ) {
        try {
            Optional<UserEntity> optionalUserEntity = userRepository.findById( userId );

            if ( optionalUserEntity.isPresent() ) {
                UserEntity optionalEntity = userRepository.findByBilkentId( id );
                if ( optionalEntity == null ) {
                    optionalUserEntity.get().setBilkentId( id );
                    userRepository.save( optionalUserEntity.get() );
                    return true;
                } else {
                    return false;
                }
            } else {
                throw new UserServiceException( "User is not found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    /**
     * Method for changing photo
     * @param userId is a long
     * @param photo is a MultipartFile
     * @return Boolean
     * @apiNote Method for changing photo
     */
    @Override
    public Boolean changePhoto ( long userId , MultipartFile photo ) {
        try {
            Optional<UserEntity> optionalUserEntity = userRepository.findById( userId );
            if ( optionalUserEntity.isPresent() ) {
                String newPath = storageService.saveProfilePhoto( photo , "users" , userId );
                optionalUserEntity.get().setPhoto( newPath );
                userRepository.save( optionalUserEntity.get() );
                return true;
            } else {
                throw new UserServiceException( "User is not found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }
}

