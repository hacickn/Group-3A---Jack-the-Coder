package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import com.jack_the_coder.bilboard_backend.model.OperationName;
import com.jack_the_coder.bilboard_backend.model.OperationStatus;
import com.jack_the_coder.bilboard_backend.model.StatusResponse;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateClubFeedbackRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.UpdateClubRequest;
import com.jack_the_coder.bilboard_backend.model.responseModel.*;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This is club controller that consists of club operations. Client interacts with that router.
 * It's path is /bilboard-app/v1/club
 * @implNote DONE
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

    /**
     * @apiNote This method is used to get club.
     * @param long clubId
     * @return ClubResponse
     */
    @GetMapping
    public ClubResponse getClub ( @RequestParam( value = "clubId" ) long clubId ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubDto clubDto = clubService.getClubById( clubId );
        return modelMapper.map( clubDto , ClubResponse.class );
    }

    /**
     * @apiNote This method is used to search clubs.
     * @param String name
     * @return List<BasicClubResponse>
     */
    @GetMapping( path = "/search" )
    public List<BasicClubResponse> searchClub ( @RequestParam( value = "name" ) String name ) {
        ModelMapper modelMapper = new ModelMapper();
        List<BasicClubResponse> basicClubResponseList = new ArrayList<>();

        clubService.searchClub( name ).forEach( clubDto -> {
            basicClubResponseList.add( modelMapper.map( clubDto , BasicClubResponse.class ) );
        } );
        return basicClubResponseList;
    }

    /**
     * @apiNote This method is used to update clubs.
     * @param UpdateClubRequest updateClubRequest
     * @return StatusResponse
     */
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

    /**
     * @apiNote This method is used to update club photo
     * @param long clubId, MultipartFile photo
     * @return StatusResponse
     */
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

    /**
     * @apiNote This method is used to create club.
     * @param long clubId
     * @return List<EventResponse>
     */
    @GetMapping( path = "/event" )
    public List<EventResponse> getEvents ( @RequestParam( value = "clubId" ) long clubId ) {
        ModelMapper modelMapper = new ModelMapper();
        List<EventResponse> eventResponseList = new ArrayList<>();

        clubService.getEvents( clubId ).forEach( eventDto -> {
            eventResponseList.add( modelMapper.map( eventDto , EventResponse.class ) );
        } );

        return eventResponseList;
    }

    /**
     * @apiNote This method is used to add board member.
     * @param long clubId, long userId
     * @return ClubBoardMemberResponse
     */
    @PostMapping( path = "/boardMember" )
    public ClubBoardMemberResponse addBoardMember ( @RequestParam( value = "clubId" ) long clubId ,
                                                    @RequestParam( value = "userId" ) long userId ) {
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map( userService.getUserById( userId ) , UserEntity.class );
        ClubEntity clubEntity = modelMapper.map( clubService.getClubById( clubId ) , ClubEntity.class );

        ClubBoardMemberDto clubBoardMemberDto = new ClubBoardMemberDto();
        clubBoardMemberDto.setClub( clubEntity );
        clubBoardMemberDto.setUser( userEntity );

        ClubBoardMemberDto created = clubService.addBoardMember( clubBoardMemberDto );

        return modelMapper.map( created , ClubBoardMemberResponse.class );
    }

    /**
     * @apiNote This method is used to delete board members.
     * @param long boardMemberId
     * @return StatusResponse
     */
    @DeleteMapping( path = "/boardMember" )
    public StatusResponse deleteBoardMember ( @RequestParam( value = "boardMemberId" ) long boardMemberId ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.DELETE.name() );

        if ( clubService.deleteBoardMember( clubService.getBoardMember( boardMemberId ) ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }
        return statusResponse;
    }

    /**
     * @apiNote This method is used to enroll club.
     * @param long clubId, long clubId
     * @return StatusResponse
     */
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

    /**
     * @apiNote This method is used to respond enroll request.
     * @param long enrollmentId, String status
     * @return StatusResponse
     */
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

    /**
     * @apiNote This method is used to delete member.
     * @param long memberId
     * @return StatusResponse
     */
    @DeleteMapping( path = "/member" )
    public StatusResponse deleteMember ( @RequestParam( value = "memberId" ) long memberId ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.DELETE.name() );

        if ( clubService.deleteMember( clubService.getMember( memberId ) ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        }
        return statusResponse;
    }

    /**
     * @apiNote This method is used to add sponsorhip.
     * @param long clubId, String name, MultipartFile photo, int amount, String type
     * @return ClubSponsorshipResponse
     */
    @PostMapping( path = "/sponsorship" )
    public ClubSponsorshipResponse addSponsorship ( @RequestParam( value = "clubId" ) long clubId ,
                                                    @RequestParam( value = "name" ) String name ,
                                                    @RequestParam( value = "photo" ) MultipartFile photo ,
                                                    @RequestParam( value = "amount" ) int amount ,
                                                    @RequestParam( value = "type" ) String type ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubSponsorshipDto clubSponsorshipDto = clubService.addSponsorship( clubId , name , photo , amount , type );

        return modelMapper.map( clubSponsorshipDto , ClubSponsorshipResponse.class );
    }

    /**
     * @apiNote This method is used to delete sponsorship.
     * @param long sponsorshipId
     * @return StatusResponse
     */
    @DeleteMapping( path = "/sponsorship" )
    public StatusResponse deleteSponsorship ( @RequestParam( value = "sponsorshipId" ) long sponsorshipId ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.DELETE.name() );

        if ( clubService.deleteSponsorship( clubService.getSponsorship( sponsorshipId ) ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }

    /**
     * @apiNote This method is used to get feedbacks.
     * @param long clubId
     * @return List<ClubFeedbackResponse>
     */
    @GetMapping( path = "/feedback" )
    public List<ClubFeedbackResponse> getFeedbacks ( @RequestParam( value = "clubId" ) long clubId ) {
        ModelMapper modelMapper = new ModelMapper();
        List<ClubFeedbackResponse> feedbackResponseList = new ArrayList<>();

        clubService.getFeedbacks( clubId ).forEach( clubFeedbackDto -> {
            feedbackResponseList.add( modelMapper.map( clubFeedbackDto , ClubFeedbackResponse.class ) );
        } );

        return feedbackResponseList;
    }

    /**
     * @apiNote This method is used to add feedback.
     * @param CreateClubFeedbackRequest createClubFeedbackRequest
     * @return ClubFeedbackResponse
     */
    @PostMapping( path = "/feedback" )
    public ClubFeedbackResponse createFeedback ( @RequestBody CreateClubFeedbackRequest createClubFeedbackRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubFeedbackDto clubFeedbackDto = modelMapper.map( createClubFeedbackRequest , ClubFeedbackDto.class );
        UserDto userDto = userService.getUserById( createClubFeedbackRequest.getUser() );
        ClubDto clubDto = clubService.getClubById( createClubFeedbackRequest.getClub() );
        clubFeedbackDto.setClub( modelMapper.map( clubDto , ClubEntity.class ) );
        clubFeedbackDto.setUser( modelMapper.map( userDto , UserEntity.class ) );
        clubFeedbackDto.setDate( new Date() );
        clubFeedbackDto.setStatus( false );
        ClubFeedbackDto created = clubService.createClubFeedback( clubFeedbackDto );
        return modelMapper.map( created , ClubFeedbackResponse.class );

    }

    /**
     * @apiNote This method is used to respond feedback.
     * @param long feedbackId, boolean status
     * @return StatusResponse
     */
    @PostMapping( path = "/feedback/respond" )
    public StatusResponse respondFeedback ( @RequestParam( value = "feedbackId" ) long feedbackId ,
                                            @RequestParam( value = "status" ) boolean status ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );

        if ( clubService.respondFeedback( clubService.getFeedback( feedbackId ) , status ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }


}
