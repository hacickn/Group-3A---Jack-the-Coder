package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.exception.UserServiceException;
import com.jack_the_coder.bilboard_backend.io.entity.EventEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import com.jack_the_coder.bilboard_backend.model.OperationName;
import com.jack_the_coder.bilboard_backend.model.OperationStatus;
import com.jack_the_coder.bilboard_backend.model.StatusResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.EventResponse;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.service.EventService;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This is club controller that consists of event operations. Client interacts with that router.
 * Its path is /bilboard-app/v1/event
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
     * Method for getting the events
     * @param eventId is a long
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
     * Method for creating an event
     * @param eventPhoto is a MultipartFile
     * @param title is a String
     * @param description is a String
     * @param duration is a String
     * @param date is a String
     * @param isOnline is a boolean
     * @param isVisible is a boolean
     * @param location is a String
     * @param maxParticipationCount is an int
     * @param gePoint is an int
     * @param restrictionForMember is a boolean
     * @param timeSlotIdList is a List<Long>
     * @param clubId is a long
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
                                       @RequestParam( "timeSlotIdList" ) String timeSlotIdList ,
                                       @RequestParam( "clubId" ) long clubId ) {
        ModelMapper modelMapper = new ModelMapper();
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
        List<Long> idList = new ArrayList<>();
        Arrays.stream( timeSlotIdList.split( "-" ) ).forEach( s -> {
            idList.add( Long.valueOf( s ) );
        } );

        Date newDate;
        try {
            newDate = formatter.parse( date );

            System.out.println( newDate );
            EventDto createdEvent =
                    eventService
                            .createEvent( eventPhoto , title , duration , description , newDate , isOnline , isVisible ,
                                    location
                                    , maxParticipationCount , gePoint , restrictionForMember , idList ,
                                    clubId );

            return modelMapper.map( createdEvent , EventResponse.class );
        } catch ( ParseException e ) {
            System.out.println( e );

            throw new UserServiceException( "Something went wrong!" );
        }

    }

    /**
     * Method for deleting an event
     * @param eventId is a long
     * @return StatusResponse
     * @apiNote This method is used to delete event.
     */
    @DeleteMapping
    public StatusResponse deleteEvent ( @RequestParam( "eventId" ) long eventId ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.DELETE.name() );
        EventDto eventDto = eventService.getEventById( eventId );

        if ( eventService.deleteEvent( eventDto ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }


    /**
     * Method for enrolling in an event
     * @param eventId is a long
     * @param userId is a long
     * @return StatusResponse
     * @apiNote This method is used to enroll event.
     */
    @PostMapping( path = "/enroll" )
    public StatusResponse enrollToEvent ( @RequestParam( "eventId" ) long eventId ,
                                          @RequestParam( "userId" ) long userId ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.ENROLL_RESPOND.name() );
        EventDto eventDto = eventService.getEventById( eventId );
        UserDto userDto = userService.getUserById( userId );

        if ( eventService.enrollToEvent( eventDto , userDto ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }

    /**
     * Method for attending an event
     * @param eventCode is a String
     * @param userId is a long
     * @return StatusResponse
     * @apiNote This method is used to attend event.
     */
    @PostMapping( path = "/attend" )
    public StatusResponse attendToEvent ( @RequestParam( "eventCode" ) String eventCode ,
                                          @RequestParam( "userId" ) long userId ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.ENROLL_REQUEST.name() );

        ModelMapper modelMapper = new ModelMapper();
        EventDto eventDto = eventService.getEventByCode( eventCode );
        System.out.println( eventDto.getId() );
        UserDto userDto = userService.getUserById( userId );
        System.out.println( userDto.getId() );

        EventParticipantDto eventParticipantDto =
                eventService.getEventParticipantByUserAndEvent( modelMapper.map( userDto , UserEntity.class ) ,
                        modelMapper.map( eventDto , EventEntity.class ) );

        // if user is already enrolled, attend event, is not create enroll request then attend event!
        if ( eventParticipantDto != null ) {
            if ( eventService.attendToEvent( eventParticipantDto ) ) {
                statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
            } else {
                statusResponse.setOperationResult( OperationStatus.ERROR.name() );
            }
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else if ( eventService.enrollToEvent( eventDto , userDto ) ) {
            eventParticipantDto =
                    eventService.getEventParticipantByUserAndEvent( modelMapper.map( userDto , UserEntity.class ) ,
                            modelMapper.map( eventDto , EventEntity.class ) );
            if ( eventService.attendToEvent( eventParticipantDto ) ) {
                statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
            } else {
                statusResponse.setOperationResult( OperationStatus.ERROR.name() );
            }
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }
        return statusResponse;
    }

    /**
     * Method for creating an event code
     * @param eventId is a long
     * @return String
     * @apiNote This method is used to create event code.
     */
    @PostMapping( path = "/eventCode" )
    public String createEventCode ( @RequestParam( "eventId" ) long eventId ) {

        EventDto eventDto = eventService.getEventById( eventId );
        return eventService.createEventCode( eventDto );
    }

    /**
     * Method for rating the event
     * @param eventId is a long
     * @param userId is a long
     * @param eventPoint is an int
     * @return StatusResponse
     * @apiNote This method is used to give points.
     */
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

    /**
     * Method for asking a question about the event
     * @param eventId is a long
     * @param userId is a long
     * @param question is a String
     * @return StatusResponse
     * @apiNote This method is used to ask question.
     */
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

    /**
     * Method for answering a question
     * @param questionId is a long
     * @param questionResponse is a String
     * @return StatusResponse
     * @apiNote This method is used to respond question.
     */
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
