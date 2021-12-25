package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.io.entity.UniversityEntity;
import com.jack_the_coder.bilboard_backend.io.repository.UniversityRepository;
import com.jack_the_coder.bilboard_backend.model.OperationName;
import com.jack_the_coder.bilboard_backend.model.OperationStatus;
import com.jack_the_coder.bilboard_backend.model.StatusResponse;
import com.jack_the_coder.bilboard_backend.model.requestModel.ResetPasswordRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.SignUpRequest;
import com.jack_the_coder.bilboard_backend.model.responseModel.SignUpResponse;
import com.jack_the_coder.bilboard_backend.service.AdminService;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.UniversityDto;
import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Hacı Çakın
 * @apiNote This is auth controller that consists of signUp/signIn, reset password, account confirmation. Client
 * interacts with that router.
 * It's path is /bilboard-app/v1/auth
 * @implNote DONE
 * @since 11.12.2021
 */
@CrossOrigin
@RestController
@RequestMapping( "/auth" )
public class AuthController {


    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @Autowired
    UniversityRepository universityRepository;

    /**
     * @param requestModel is a SignUpRequest instance
     * @apiNote This method is used to sign up a new user.
     * @ return SignUpResponse
     */
    @PostMapping( path = "/signUp" )
    public SignUpResponse signUp ( @RequestBody SignUpRequest requestModel ) {
        ModelMapper modelMapper = new ModelMapper();
        UniversityDto universityDto = adminService.getUniversity( requestModel.getUniversity() );


        if ( universityDto == null ) {
            UniversityEntity entity = new UniversityEntity();
            entity.setName( "Bilkent" );
            UniversityEntity created = universityRepository.save( entity );
            universityDto = modelMapper.map( created , UniversityDto.class );
        }

        UserDto userDto = modelMapper.map( requestModel , UserDto.class );
        userDto.setUniversity( modelMapper.map( universityDto , UniversityEntity.class ) );

        UserDto createdDto = userService.createUser( userDto );
        return modelMapper.map( createdDto , SignUpResponse.class );
    }


    /**
     * @param token is a string
     * @return StatusResponse
     * @apiNote This method is used to verify email.
     */
    @PostMapping( path = "/emailVerification" )
    public StatusResponse signUpConfirmation ( @RequestParam( value = "token" ) String token ) {
        StatusResponse returnValue = new StatusResponse();
        returnValue.setOperationName( OperationName.VERIFY_EMAIL.name() );

        boolean isVerified = userService.verifyEmailToken( token );

        if ( isVerified ) {
            returnValue.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            returnValue.setOperationResult( OperationStatus.ERROR.name() );
        }

        return returnValue;
    }

    /**
     * @param email is a String
     * @return StatusResponse
     * @apiNote This method is used to request resetting password.
     */
    @PostMapping( path = "/resetPasswordRequest" )
    public StatusResponse forgetPassword ( @RequestParam( value = "email" ) String email ) {
        StatusResponse returnValue = new StatusResponse();

        boolean operationResult = userService.requestPasswordReset( email );

        returnValue.setOperationName( OperationName.REQUEST_PASSWORD_RESET.name() );
        returnValue.setOperationResult( OperationStatus.ERROR.name() );

        if ( operationResult ) {
            returnValue.setOperationResult( OperationStatus.SUCCESS.name() );
        }

        return returnValue;
    }

    /**
     * @param requestModel is a ResetPasswordRequest instance
     * @return StatusResponse
     * @apiNote This method is used to reset password.
     */
    @PostMapping( path = "/resetPassword" )
    public StatusResponse changePassword ( @RequestBody ResetPasswordRequest requestModel ) {
        StatusResponse returnValue = new StatusResponse();

        boolean operationResult = userService.resetPassword(
                requestModel.getToken() ,
                requestModel.getNewPassword() );

        returnValue.setOperationName( OperationName.PASSWORD_RESET.name() );
        returnValue.setOperationResult( OperationStatus.ERROR.name() );

        if ( operationResult ) {
            returnValue.setOperationResult( OperationStatus.SUCCESS.name() );
        }

        return returnValue;
    }

}
