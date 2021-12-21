package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import com.jack_the_coder.bilboard_backend.model.OperationName;
import com.jack_the_coder.bilboard_backend.model.OperationStatus;
import com.jack_the_coder.bilboard_backend.model.StatusResponse;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateClubFeedbackRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.UpdateClubRequest;
import com.jack_the_coder.bilboard_backend.model.responseModel.ClubFeedbackResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.ClubResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.ClubSponsorshipResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.EventResponse;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubDto;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubFeedbackDto;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubSponsorshipDto;
import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This is club controller that consists of club operations. Client interacts with that router.
 * It's path is /bilboard-app/v1/club
 * @implNote NOT Completed
 * @since 11.12.2021
 */
@CrossOrigin
@RestController
@RequestMapping( "/club" )
public class ClubController {

    @Autowired
    ClubService clubService;

    @Autowired
    UserService userService;

    @GetMapping
    public ClubResponse getClub ( @RequestParam( value = "clubId" ) long clubId ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubDto clubDto = clubService.getClub( clubId );
        return modelMapper.map( clubDto , ClubResponse.class );
    }

    @GetMapping( path = "/event" )
    public List<EventResponse> getEvents ( @RequestParam( value = "clubId" ) long clubId ) {
        ModelMapper modelMapper = new ModelMapper();
        List<EventResponse> eventResponseList = new ArrayList<>();

        clubService.getEvents( clubId ).forEach( eventDto -> {
            eventResponseList.add( modelMapper.map( eventDto , EventResponse.class ) );
        } );

        return eventResponseList;
    }

    @GetMapping( path = "/feedback" )
    public List<ClubFeedbackResponse> getFeedbacks ( @RequestParam( value = "clubId" ) long clubId ) {
        ModelMapper modelMapper = new ModelMapper();
        List<ClubFeedbackResponse> feedbackResponseList = new ArrayList<>();

        clubService.getFeedbacks( clubId ).forEach( clubFeedbackDto -> {
            feedbackResponseList.add( modelMapper.map( clubFeedbackDto , ClubFeedbackResponse.class ) );
        } );

        return feedbackResponseList;
    }

    @PostMapping( path = "/update" )
    public StatusResponse updateClub ( @RequestBody UpdateClubRequest updateClubRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubDto clubDto = modelMapper.map( updateClubRequest , ClubDto.class );
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );

        if ( clubService.updateClub( clubDto ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }


    @PostMapping( path = "/updatePhoto" )
    public StatusResponse updateClubPhoto ( @RequestParam( value = "clubId" ) long clubId ,
                                            @RequestParam( value = "photo" ) MultipartFile photo ) {

        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );

        if ( clubService.updatePhoto( clubId , photo ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }
        return statusResponse;
    }

    @PostMapping( path = "/enrollment/request" )
    public StatusResponse enrollClub ( @RequestParam( value = "userId" ) long userId ,
                                       @RequestParam( value = "clubId" ) long clubId ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.ENROLL_REQUEST.name() );
        if ( clubService.enrollClub( userId , clubId ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }

    @PostMapping( path = "/enrollment/respond" )
    public StatusResponse respondEnrollRequest ( @RequestParam( value = "enrollmentId" ) long enrollmentId ,
                                                 @RequestParam( value = "status" ) String status ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.ENROLL_RESPOND.name() );

        if ( clubService.respondEnrollRequest( enrollmentId , status ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }

    @PostMapping( path = "/sponsorship/create" )
    public ClubSponsorshipResponse addSponsorship ( @RequestParam( value = "clubId" ) long clubId ,
                                                    @RequestParam( value = "name" ) String name ,
                                                    @RequestParam( value = "photo" ) MultipartFile photo ,
                                                    @RequestParam( value = "amount" ) int amount ,
                                                    @RequestParam( value = "type" ) String type ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubSponsorshipDto clubSponsorshipDto = clubService.addSponsorship( clubId , name , photo , amount , type );

        return modelMapper.map( clubSponsorshipDto , ClubSponsorshipResponse.class );
    }

    @PostMapping( path = "/feedback/create" )
    public ClubFeedbackResponse createFeedback ( @RequestBody CreateClubFeedbackRequest createClubFeedbackRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubFeedbackDto clubFeedbackDto = modelMapper.map( createClubFeedbackRequest, ClubFeedbackDto.class );
        UserDto userDto = userService.getUserById( createClubFeedbackRequest.getUser() );
        ClubDto clubDto = clubService.getClub( createClubFeedbackRequest.getClub() );
        clubFeedbackDto.setClub( modelMapper.map( clubDto, ClubEntity.class ) );
        clubFeedbackDto.setUser( modelMapper.map( userDto, UserEntity.class ) );
        ClubFeedbackDto created = clubService.createClubFeedback( clubFeedbackDto );
        return modelMapper.map( created, ClubFeedbackResponse.class );

    }

}
