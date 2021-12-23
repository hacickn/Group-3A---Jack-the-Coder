package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.io.entity.EventParticipantEntity;
import com.jack_the_coder.bilboard_backend.model.OperationName;
import com.jack_the_coder.bilboard_backend.model.OperationStatus;
import com.jack_the_coder.bilboard_backend.model.StatusResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.EventResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.UserDetailResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.UserResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;
import com.jack_the_coder.bilboard_backend.service.EventService;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This is club controller that consists of user operations. Client interacts with that router.
 * It's path is /bilboard-app/v1/user
 * @implNote DONE
 * @since 11.12.2021
 */
@CrossOrigin
@RestController
@RequestMapping( "/user" )
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    EventService eventService;

    /**
     * @apiNote This method is used to get user.
     * @param long userId
     * @return UserResponse
     */
    @GetMapping
    public UserResponse getUser ( @RequestParam( value = "userId" ) long userId ) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = userService.getUserById( userId );
        return modelMapper.map( userDto , UserResponse.class );
    }

    /**
     * @apiNote This method is used to search users.
     * @param String name, String type
     * @return List<BasicUserResponse>
     */
    @GetMapping( path = "/search" )
    public List<BasicUserResponse> searchUser ( @RequestParam( value = "name" ) String name ,
                                                @RequestParam( value = "type" ) String type ) {
        ModelMapper modelMapper = new ModelMapper();
        List<BasicUserResponse> basicUserResponseList = new ArrayList<>();

        userService.searchUser( name , type ).forEach( userDto -> {
            basicUserResponseList.add( modelMapper.map( userDto , BasicUserResponse.class ) );
        } );

        return basicUserResponseList;
    }

    /**
     * @apiNote This method is used to get user detail.
     * @param long userId
     * @return UserDetailResponse
     */
    @GetMapping( value = "/detail" )
    public UserDetailResponse getUserDetail ( @RequestParam( value = "userId" ) long userId ) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = userService.getUserById( userId );
        List<EventResponse> futureEvents = new ArrayList<>();
        List<EventResponse> pastEvents = new ArrayList<>();

        userDto.getEventParticipants().forEach( eventParticipantEntity -> {
            if(eventParticipantEntity.getEvent().getDate().after( new Date() )){
                futureEvents.add( modelMapper.map( eventParticipantEntity.getEvent(),EventResponse.class ) );
            }else{
                pastEvents.add( modelMapper.map( eventParticipantEntity.getEvent(),EventResponse.class ) );
            }
        } );

        List<EventResponse> followingClubsEvents = new ArrayList<>();
        userDto.getClubMemberShips().forEach( clubMemberEntity -> {
            clubMemberEntity.getClub().getEvents().forEach( eventEntity -> {
                if(eventEntity.getDate().after( new Date() )){
                    followingClubsEvents.add( modelMapper.map( eventEntity,EventResponse.class ) );
                }
            } );
        } );


        UserDetailResponse userDetailResponse = modelMapper.map( userDto , UserDetailResponse.class );


        List<EventResponse> eventResponseList = new ArrayList<>();
        eventService.getDiscover().forEach( eventDto -> {
            eventResponseList.add( modelMapper.map( eventDto,EventResponse.class ) );
        } );

        userDetailResponse.setDiscover( eventResponseList );
        userDetailResponse.setFollowingClubsEvents( followingClubsEvents );
        userDetailResponse.setFutureEvents( futureEvents );
        userDetailResponse.setPastEvents( pastEvents );
        return userDetailResponse;
    }

    /**
     * @apiNote This method is used to get user ge point.
     * @param long userId
     * @return int
     */
    @GetMapping( value = "/gePoint" )
    public int getUserGePoint ( @RequestParam( value = "userId" ) long userId ) {
        UserDto userDto = userService.getUserById( userId );
        return userDto.getEventParticipants().stream().filter( EventParticipantEntity::getAttended )
                .mapToInt( EventParticipantEntity::getPoint ).sum();
    }

    /**
     * @apiNote This method is used to get change ge status.
     * @param long userId, boolean geStatus
     * @return StatusResponse
     */
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

    /**
     * @apiNote This method is used to change the name and surname of the user.
     * @param long userId, String name, String surname
     * @return StatusResponse
     */
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

    /**
     * @apiNote This method is used to change the id of the user.
     * @param long userId, String id
     * @return StatusResponse
     */
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

    /**
     * @apiNote This method is used to change the email of the user.
     * @param long userId, MultipartFile photo
     * @return StatusResponse
     */
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
