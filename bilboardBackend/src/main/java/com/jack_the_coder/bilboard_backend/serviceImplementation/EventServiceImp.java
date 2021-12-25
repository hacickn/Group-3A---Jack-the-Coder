package com.jack_the_coder.bilboard_backend.serviceImplementation;

import com.jack_the_coder.bilboard_backend.exception.UserServiceException;
import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.EventEntity;
import com.jack_the_coder.bilboard_backend.io.repository.EventRepository;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.service.EventService;
import com.jack_the_coder.bilboard_backend.service.ReservationService;
import com.jack_the_coder.bilboard_backend.service.StorageService;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubDto;
import com.jack_the_coder.bilboard_backend.shared.dto.EventDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImp implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ClubService clubService;

    @Autowired
    ReservationService reservationService;

    @Autowired
    StorageService storageService;

    @Override
    public EventDto getEvent ( long eventId ) {
        try {
            ModelMapper modelMapper = new ModelMapper();

            Optional<EventEntity> eventEntity = eventRepository.findById( eventId );

            if ( eventEntity.isPresent() ) {
                return modelMapper.map( eventEntity.get() , EventDto.class );
            } else {
                throw new UserServiceException( "Event is NOT found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    @Override
    public EventDto createEvent ( MultipartFile eventPhoto , String title , String duration , String description ,
                                  Date date ,
                                  Boolean isOnline , Boolean isVisible , String location , int maxParticipationCount ,
                                  int gePoint , Boolean restrictionForMember , List<Long> timeSlotIdList ,
                                  long clubId ) {
        ModelMapper modelMapper = new ModelMapper();
        EventDto eventDto = new EventDto();
        ClubDto clubDto = clubService.getClubById( clubId );
        eventDto.setClub( modelMapper.map( clubDto , ClubEntity.class ) );
        eventDto.setTitle( title );
        eventDto.setDescription( description );
        eventDto.setDate( date );
        eventDto.setOnline( isOnline );
        eventDto.setLocation( location );
        eventDto.setMaxParticipationCount( maxParticipationCount );
        eventDto.setDuration( duration );
        eventDto.setGePoint( gePoint );
        eventDto.setRestrictionForMember( restrictionForMember );
        eventDto.setVisible( isVisible );
        String fileName = storageService.saveEventPhoto( eventPhoto , "event" , clubId + "" );
        eventDto.setEventPhoto( fileName );
        EventEntity eventEntity = modelMapper.map( eventDto , EventEntity.class );
        EventEntity createdEvent = eventRepository.save( eventEntity );

        if ( !isOnline ) {
            reservationService.createLocationRequest( timeSlotIdList , createdEvent );
        }

        return modelMapper.map( createdEvent , EventDto.class );
    }

    @Override
    public List<EventDto> getDiscover () {
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<EventDto> eventDtoList = new ArrayList<>();
            List<EventEntity> eventEntityList = eventRepository.findFirst10ByDateAfter( new Date() );
            int trace = 0;
            while ( trace < eventEntityList.size() && eventDtoList.size() < 20 ) {
                eventDtoList.add( modelMapper.map( eventEntityList.get( trace ) , EventDto.class ) );
                trace++;
            }


            return eventDtoList;
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
        }
    }
}
