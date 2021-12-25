package com.jack_the_coder.bilboard_backend.serviceImplementation;

import com.jack_the_coder.bilboard_backend.exception.UserServiceException;
import com.jack_the_coder.bilboard_backend.io.entity.*;
import com.jack_the_coder.bilboard_backend.io.repository.*;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.service.EventService;
import com.jack_the_coder.bilboard_backend.service.ReservationService;
import com.jack_the_coder.bilboard_backend.service.StorageService;
import com.jack_the_coder.bilboard_backend.shared.dto.*;
import com.jack_the_coder.bilboard_backend.util.Utils;
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

    @Autowired
    EventQuestionRepository eventQuestionRepository;

    @Autowired
    EventParticipantRepository eventParticipantRepository;

    @Autowired
    ClubMemberRepository clubMemberRepository;


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

    @Override
    public Boolean deleteEvent ( EventDto eventDto ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            eventParticipantRepository.deleteAll( eventDto.getEventParticipants() );
            eventQuestionRepository.deleteAll( eventDto.getEventQuestions() );
            reservationService.deleteLocationRequests( eventDto.getLocationRequests() );
            eventRepository.delete( modelMapper.map( eventDto , EventEntity.class ) );

            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    @Override
    public Boolean enrollToEvent ( EventDto eventDto , UserDto userDto ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            if ( !eventDto.getRestrictionForMember() || clubMemberRepository
                    .findByClubAndUser( eventDto.getClub() , modelMapper.map( userDto , UserEntity.class ) ) != null ) {

                Optional<EventParticipantEntity> optional =
                        eventParticipantRepository.findByUserAndEvent( modelMapper.map( userDto ,
                                UserEntity.class ) ,
                                modelMapper.map( eventDto , EventEntity.class ) );

                if ( !optional.isPresent() ) {
                    EventParticipantDto eventParticipantDto = new EventParticipantDto();
                    eventParticipantDto.setEvent( modelMapper.map( eventDto , EventEntity.class ) );
                    eventParticipantDto.setPointGiven( false );
                    eventParticipantDto.setAttended( false );
                    eventParticipantDto.setUser( modelMapper.map( userDto , UserEntity.class ) );
                    eventParticipantRepository
                            .save( modelMapper.map( eventParticipantDto , EventParticipantEntity.class ) );
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch ( Exception e ) {
            return false;
        }
    }

    @Override
    public Boolean attendToEvent ( EventParticipantDto eventParticipantDto ) {
        try {
            eventParticipantDto.setAttended( true );
            ClubMemberEntity clubMemberEntity =
                    clubMemberRepository.findByClubAndUser( eventParticipantDto.getEvent().getClub() ,
                            eventParticipantDto.getUser() );
            clubMemberEntity.setGePoint( clubMemberEntity.getGePoint() + eventParticipantDto.getEvent().getGePoint() );
            clubMemberEntity.setAttendedEventCount( clubMemberEntity.getAttendedEventCount() + 1 );
            clubMemberRepository.save( clubMemberEntity );
            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    @Override
    public String createEventCode ( EventDto eventDto ) {
        try {
            Utils utils = new Utils();
            ModelMapper modelMapper = new ModelMapper();
            String newCode = utils.generateRandomString( 8 );

            while ( eventRepository.findByEventCode( newCode ).isPresent() ) {
                newCode = utils.generateRandomString( 8 );
            }

            eventDto.setEventCode( newCode );
            eventDto.setEventCodeExpire( new Date( new Date().getTime() + 1000 * 60 * 10 ) );
            eventRepository.save( modelMapper.map( eventDto , EventEntity.class ) );
            return newCode;
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    @Override
    public Boolean givePointToEvent ( EventDto eventDto , UserDto userDto , int point ) {
        try {
            ModelMapper modelMapper = new ModelMapper();

            EventParticipantDto eventParticipantDto =
                    getEventParticipantByUserAndEvent( modelMapper.map( userDto , UserEntity.class ) ,
                            modelMapper.map( eventDto , EventEntity.class ) );

            if ( eventParticipantDto.getAttended() && !eventParticipantDto.getPointGiven() ) {
                eventParticipantDto.setPointGiven( true );
                eventParticipantDto.setPoint( point );

                eventParticipantRepository
                        .save( modelMapper.map( eventParticipantDto , EventParticipantEntity.class ) );
                return true;
            } else {
                return false;
            }

        } catch ( Exception e ) {
            return false;
        }
    }

    @Override
    public Boolean askQuestion ( EventDto eventDto , String question , UserDto userDto ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            EventQuestionDto eventQuestionDto = new EventQuestionDto();
            eventQuestionDto.setQuestion( question );
            eventQuestionDto.setDate( new Date() );
            eventQuestionDto.setUser( modelMapper.map( userDto , UserEntity.class ) );
            eventQuestionDto.setEvent( modelMapper.map( eventDto , EventEntity.class ) );
            eventQuestionRepository.save( modelMapper.map( eventQuestionDto , EventQuestionEntity.class ) );
            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    @Override
    public Boolean respondToQuestion ( EventQuestionDto eventQuestionDto , String answer ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            eventQuestionDto.setAnswer( answer );
            eventQuestionRepository.save( modelMapper.map( eventQuestionDto , EventQuestionEntity.class ) );
            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    @Override
    public EventDto getEventById ( long id ) {
        try {
            Optional<EventEntity> optional = eventRepository.findById( id );

            if ( optional.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map( optional.get() , EventDto.class );
            } else {
                throw new UserServiceException( "Event could not be found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    @Override
    public EventQuestionDto getQuestionById ( long eventQuestionId ) {
        try {
            Optional<EventQuestionEntity> optional = eventQuestionRepository.findById( eventQuestionId );

            if ( optional.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map( optional.get() , EventQuestionDto.class );
            } else {
                throw new UserServiceException( "Event question could not be found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    @Override
    public EventParticipantDto getEventParticipantById ( long eventParticipantId ) {
        try {
            Optional<EventParticipantEntity> optional = eventParticipantRepository.findById( eventParticipantId );

            if ( optional.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map( optional.get() , EventParticipantDto.class );
            } else {
                return null;
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    @Override
    public EventParticipantDto getEventParticipantByUserAndEvent ( UserEntity userEntity , EventEntity eventEntity ) {
        try {
            Optional<EventParticipantEntity> optional =
                    eventParticipantRepository.findByUserAndEvent( userEntity , eventEntity );
            System.out.println(userEntity.getId());
            System.out.println(eventEntity.getId());

            System.out.println(optional.get());
            if ( optional.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map( optional.get() , EventParticipantDto.class );
            } else {
                return null;
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    @Override
    public EventDto getEventByCode ( String code ) {
        try {
            Optional<EventEntity> optional = eventRepository.findByEventCode( code );

            if ( optional.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map( optional.get() , EventDto.class );
            } else {
                throw new UserServiceException( "Event could not be found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }
}
