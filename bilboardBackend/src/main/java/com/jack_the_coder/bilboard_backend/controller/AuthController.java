package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.io.entity.UniversityEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import com.jack_the_coder.bilboard_backend.io.repository.UniversityRepository;
import com.jack_the_coder.bilboard_backend.model.OperationName;
import com.jack_the_coder.bilboard_backend.model.OperationStatus;
import com.jack_the_coder.bilboard_backend.model.StatusResponse;
import com.jack_the_coder.bilboard_backend.model.requestModel.ResetPasswordRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.SignUpRequest;
import com.jack_the_coder.bilboard_backend.model.responseModel.SignUpResponse;
import com.jack_the_coder.bilboard_backend.service.AdminService;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubDto;
import com.jack_the_coder.bilboard_backend.shared.dto.UniversityDto;
import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hacı Çakın
 * @apiNote This is auth controller that consists of signUp/signIn, reset password, account confirmation. Client
 * interacts with that router.
 * Its path is /bilboard-app/v1/auth
 * @implNote DONE
 * @since 11.12.2021
 */
@CrossOrigin
@RestController
@RequestMapping( "/auth" )
public class AuthController {

    static boolean defaultUserCreated = false;

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @Autowired
    ClubService clubService;

    @Autowired
    UniversityRepository universityRepository;

    /**
     * Method for registration
     * @param requestModel is a SignUpRequest instance
     * @return SignUpResponse
     * @apiNote This method is used to sign up a new user.
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

        if ( !defaultUserCreated ) {

            if(userService.getUserById( 2 ) == null){
                UserDto adminDto = new UserDto();
                adminDto.setName( "Admin" );
                adminDto.setSurname( "Admin" );
                adminDto.setBilkentId( "0000000000" );
                adminDto.setType( UserEntity.UserTypes.admin );
                adminDto.setEmail( "admin@bilkent.edu.tr" );
                adminDto.setPassword( "test1234" );
                adminDto.setEmailConfirmation( true );
                adminDto.setUniversity( modelMapper.map( universityDto , UniversityEntity.class ) );
                userService.createUser( adminDto );

                UserDto assistantDto = new UserDto();
                assistantDto.setName( "Administrative" );
                assistantDto.setSurname( "Assistants" );
                assistantDto.setBilkentId( "99999999999" );
                assistantDto.setType( UserEntity.UserTypes.administrativeAssistants );
                assistantDto.setEmail( "a.a@bilkent.edu.tr" );
                assistantDto.setEmailConfirmation( true );
                assistantDto.setPassword( "test1234" );
                assistantDto.setUniversity( modelMapper.map( universityDto , UniversityEntity.class ) );
                userService.createUser( assistantDto );

                UserDto studentDto = new UserDto();
                studentDto.setName( "Student" );
                studentDto.setSurname( "Student" );
                studentDto.setBilkentId( "43787843" );
                studentDto.setType( UserEntity.UserTypes.student );
                studentDto.setEmail( "student@ug.bilkent.edu.tr" );
                studentDto.setEmailConfirmation( true );
                studentDto.setPassword( "test1234" );
                studentDto.setUniversity( modelMapper.map( universityDto , UniversityEntity.class ) );
                userService.createUser( studentDto );

                UserDto academicDto = new UserDto();
                academicDto.setName( "Academic" );
                academicDto.setSurname( "Academic" );
                academicDto.setBilkentId( "43787844" );
                academicDto.setType( UserEntity.UserTypes.academic );
                academicDto.setEmail( "academic@bilkent.edu.tr" );
                academicDto.setEmailConfirmation( true );
                academicDto.setPassword( "test1234" );
                academicDto.setUniversity( modelMapper.map( universityDto , UniversityEntity.class ) );
                userService.createUser( academicDto );

                ClubDto clubDto = new ClubDto();
                clubDto.setName( "Toplumsal Duyarlılık Projeleri" );
                clubDto.setShortName( "TDP" );
                clubService.createClub( clubDto );
            }



            defaultUserCreated = true;
        }


        UserDto userDto = modelMapper.map( requestModel , UserDto.class );
        userDto.setEmailConfirmation( false );
        userDto.setUniversity( modelMapper.map( universityDto , UniversityEntity.class ) );

        UserDto createdDto = userService.createUser( userDto );
        return modelMapper.map( createdDto , SignUpResponse.class );
    }


    /**
     * Method for email verification
     * @param token is a String
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
     * Method to handle forgetting password case
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
     * Method for resetting password
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
