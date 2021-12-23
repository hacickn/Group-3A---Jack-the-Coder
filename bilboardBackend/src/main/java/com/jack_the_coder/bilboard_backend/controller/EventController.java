package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.exception.UserServiceException;
import com.jack_the_coder.bilboard_backend.model.responseModel.EventResponse;
import com.jack_the_coder.bilboard_backend.service.EventService;
import com.jack_the_coder.bilboard_backend.shared.dto.EventDto;
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

    /**
     * @apiNote This method is used to get event.
     * @param long eventId
     * @return EventResponse
     */
    @GetMapping
    public EventResponse getEvent ( @RequestParam( value = "eventId" ) long eventId ) {
        ModelMapper modelMapper = new ModelMapper();

        EventDto eventDto = eventService.getEvent( eventId );

        return modelMapper.map( eventDto , EventResponse.class );
    }

    /**
     * @apiNote This method is used to create an event.
     * @param MultipartFile eventPhoto, String title, String description, String duration, 
     *      String date, Boolean isOnline, Boolean isVisible, String location
     *      int maxParticipantCount, int gePoint, Boolean restrictionForMember,
     *      List <Long> timeSlotIdList, lung clubId
     * @return EventResponse
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
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

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
            throw new UserServiceException( "Something went wrong!" );
        }

    }
}
