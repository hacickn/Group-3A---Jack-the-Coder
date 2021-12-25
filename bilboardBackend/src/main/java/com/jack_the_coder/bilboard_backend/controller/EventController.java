package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.exception.UserServiceException;
import com.jack_the_coder.bilboard_backend.model.OperationName;
import com.jack_the_coder.bilboard_backend.model.OperationStatus;
import com.jack_the_coder.bilboard_backend.model.StatusResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.EventResponse;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.service.EventService;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubDto;
import com.jack_the_coder.bilboard_backend.shared.dto.EventDto;
import com.jack_the_coder.bilboard_backend.shared.dto.EventQuestionDto;
import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This is club controller that consists of event operations. Client interacts with that router.
 * It's path is /bilboard-app/v1/event
 * @implNote DONE
 * @since 11.12.2021
 */
@CrossOrigin
@RestController
@RequestMapping( "/event" )
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    @Autowired
    ClubService clubService;

    /**
     * @param eventId is long
     * @return EventResponse
     * @apiNote This method is used to get event.
     */
    @GetMapping
    public EventResponse getEvent ( @RequestParam( value = "eventId" ) long eventId ) {
        ModelMapper modelMapper = new ModelMapper();

        EventDto eventDto = eventService.getEvent( eventId );

        return modelMapper.map( eventDto , EventResponse.class );
    }

    /**
     * @param eventPhoto is a MultipartFile, String title, String description, String duration,
     *                   String date, Boolean isOnline, Boolean isVisible, String location
     *                   int maxParticipantCount, int gePoint, Boolean restrictionForMember,
     *                   List <Long> timeSlotIdList, lung clubId
     * @return EventResponse
     * @apiNote This method is used to create an event.
     */
    @PostMapping
    public EventResponse createEvent ( @RequestParam( "eventPhoto" ) MultipartFile eventPhoto ,
                                       @RequestParam( "title" ) String title ,
                                       @RequestParam( "description" ) String description ,
                                       @RequestParam( "duration" ) String duration ,
                                       @RequestParam( "date" ) String date ,
                                       @RequestParam( "isOnline" ) Boolean isOnline ,
                                       @RequestParam( "isVisible" ) Boolean isVisible ,
                                       @RequestParam( "location" ) String location ,
                                       @RequestParam( "maxParticipationCount" ) int maxParticipationCount ,
                                       @RequestParam( "gePoint" ) int gePoint ,
                                       @RequestParam( "restrictionForMember" ) Boolean restrictionForMember ,
                                       @RequestParam( "timeSlotIdList" ) List<Long> timeSlotIdList ,
                                       @RequestParam( "clubId" ) long clubId ) {
        ModelMapper modelMapper = new ModelMapper();
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm" );

        Date newDate;
        try {
            newDate = formatter.parse( date );

            System.out.println( newDate );
            EventDto createdEvent =
                    eventService
                            .createEvent( eventPhoto , title , duration , description , newDate , isOnline , isVisible ,
                                    location
                                    , maxParticipationCount , gePoint , restrictionForMember , timeSlotIdList ,
                                    clubId );

            return modelMapper.map( createdEvent , EventResponse.class );
        } catch ( ParseException e ) {
            System.out.println( e );

            throw new UserServiceException( "Something went wrong!" );
        }

    }


    @DeleteMapping
    public StatusResponse deleteEvent ( @RequestParam( "eventId" ) long eventId ) {
        StatusResponse statusResponse = new StatusResponse();


        return statusResponse;
    }


    @PostMapping( path = "/enroll" )
    public StatusResponse enrollToEvent ( @RequestParam( "eventId" ) long eventId ,
                                          @RequestParam( "userId" ) long userId ) {
        StatusResponse statusResponse = new StatusResponse();


        return statusResponse;
    }

    @PostMapping( path = "/attend" )
    public StatusResponse attendToEvent ( @RequestParam( "eventId" ) long eventId ,
                                          @RequestParam( "userId" ) long userId ) {
        StatusResponse statusResponse = new StatusResponse();


        return statusResponse;
    }

    @PostMapping( path = "/eventCode" )
    public String createEventCode ( @RequestParam( "eventId" ) long eventId ) {

        EventDto eventDto = eventService.getEventById( eventId );
        return eventService.createEventCode( eventDto );
    }

    @PostMapping( path = "/givePoint" )
    public StatusResponse givePoint ( @RequestParam( "eventId" ) long eventId ,
                                      @RequestParam( "userId" ) long userId ,
                                      @RequestParam( "eventPoint" ) int eventPoint ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );
        EventDto eventDto = eventService.getEventById( eventId );
        UserDto userDto = userService.getUserById( userId );

        if ( eventService.givePointToEvent( eventDto , userDto , eventPoint ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }
        return statusResponse;
    }

    @PostMapping( path = "/askQuestion" )
    public StatusResponse askQuestion ( @RequestParam( "eventId" ) long eventId ,
                                        @RequestParam( "userId" ) long userId ,
                                        @RequestParam( "eventQuestion" ) String question ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.CREATION.name() );
        UserDto userDto = userService.getUserById( userId );
        EventDto eventDto = eventService.getEventById( eventId );

        if ( eventService.askQuestion( eventDto , question , userDto ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }

    @PostMapping( path = "/respondToQuestion" )
    public StatusResponse respondToQuestion ( @RequestParam( "questionId" ) long questionId ,
                                              @RequestParam( "questionResponse" ) String questionResponse ) {
        StatusResponse statusResponse = new StatusResponse();
        EventQuestionDto eventQuestionDto = eventService.getQuestionById( questionId );
        statusResponse.setOperationName( OperationName.UPDATE.name() );

        if ( eventService.respondToQuestion( eventQuestionDto , questionResponse ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }
        return statusResponse;
    }


}
