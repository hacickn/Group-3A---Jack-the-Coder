package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.io.entity.EventParticipantEntity;
import com.jack_the_coder.bilboard_backend.model.OperationName;
import com.jack_the_coder.bilboard_backend.model.OperationStatus;
import com.jack_the_coder.bilboard_backend.model.StatusResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.UserDetailResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.UserResponse;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hacı Çakın
 * @apiNote This is club controller that consists of user operations. Client interacts with that router.
 * It's path is /bilboard-app/v1/user
 * @implNote NOT Completed
 * @since 11.12.2021
 */
@CrossOrigin
@RestController
@RequestMapping( "/user" )
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public UserResponse getUser ( @RequestParam( value = "userId" ) long userId ) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = userService.getUserById( userId );
        return modelMapper.map( userDto , UserResponse.class );
    }

    @GetMapping(value = "/detail")
    public UserDetailResponse getUserDetail(@RequestParam(value = "userId") long userId){
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = userService.getUserById( userId );
        return modelMapper.map( userDto,UserDetailResponse.class );
    }

    @GetMapping(value = "/gePoint")
    public int getUserGePoint(@RequestParam(value = "userId") long userId){
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = userService.getUserById( userId );
        return userDto.getEventParticipants().stream().filter( EventParticipantEntity::getAttended )
                .mapToInt( EventParticipantEntity::getPoint ).sum();
    }

    @PostMapping( path = "/changeGeStatus" )
    public StatusResponse changeGeStatus ( @RequestParam( value = "userId" ) long userId ,
                                           @RequestParam( value = "geStatus" ) boolean geStatus ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );
        if ( userService.changeGeStatus( userId , geStatus ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );

        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }
        return statusResponse;
    }

    @PostMapping( path = "/changeNameSurname" )
    public StatusResponse changeNameSurname ( @RequestParam( value = "userId" ) long userId ,
                                              @RequestParam( value = "name" ) String name ,
                                              @RequestParam( value = "surname" ) String surname ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );
        if ( userService.changeNameSurname( userId , name , surname ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );

        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }
        return statusResponse;
    }

    @PostMapping( path = "/changeId" )
    public StatusResponse changeId ( @RequestParam( value = "userId" ) long userId ,
                                     @RequestParam( value = "id" ) String id ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );
        if ( userService.changeId( userId , id ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );

        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }
        return statusResponse;
    }

    @PostMapping( path = "/changePhoto" )
    public StatusResponse changePhoto ( @RequestParam( value = "userId" ) long userId ,
                                        @RequestParam( value = "photo" ) MultipartFile photo ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );
        if ( userService.changePhoto( userId , photo ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }
}
