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


    /**
     * Method for getting an event
     * @param eventId is a long
     * @return EventDto
     * @apiNote Method for getting an event
     */
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

    /**
     * Method for creating an event
     * @param eventPhoto is a MultipartFile
     * @param title is a String
     * @param duration is a String
     * @param description is a String
     * @param date is a Date
     * @param isOnline is a Boolean
     * @param isVisible is a Boolean
     * @param location is a String
     * @param maxParticipationCount is a int
     * @param gePoint is a int
     * @param restrictionForMember is a Boolean
     * @param timeSlotIdList is a List<Long>
     * @param clubId is a long
     * @return EventDto
     * @apiNote Method for creating an event
     */
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

    /**
     * Method for get discover events
     * @return List<EventDto>
     * @apiNote Method for get discover
     */
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

    /**
     * Method for deleting event
     * @param eventDto is a EventDto
     * @return List<EventDto>
     * @apiNote Method for deleting event
     */
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

    /**
     * Method for enrolling to an event
     * @param eventDto is a EventDto
     * @param userDto is a UserDto
     * @return Boolean
     * @apiNote Method for enrolling to an event
     */
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

    /**
     * Method for attending to an event
     * @param eventParticipantDto is a EventParticipantDto
     * @return Boolean
     * @apiNote Method for attending to an event
     */
    @Override
    public Boolean attendToEvent ( EventParticipantDto eventParticipantDto ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            eventParticipantDto.setAttended( true );
            ClubMemberEntity clubMemberEntity =
                    clubMemberRepository.findByClubAndUser( eventParticipantDto.getEvent().getClub() ,
                            eventParticipantDto.getUser() );
            if ( clubMemberEntity != null ) {
                clubMemberEntity
                        .setGePoint( clubMemberEntity.getGePoint() + eventParticipantDto.getEvent().getGePoint() );
                clubMemberEntity.setAttendedEventCount( clubMemberEntity.getAttendedEventCount() + 1 );
                clubMemberRepository.save( clubMemberEntity );
            }
            eventParticipantRepository.save( modelMapper.map( eventParticipantDto , EventParticipantEntity.class ) );

            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    /**
     * Method for creating an event code
     * @param eventDto is a EventDto
     * @return String
     * @apiNote Method for creating an event code
     */
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

    /**
     * Method for giving point to an event
     * @param eventDto is a EventDto
     * @param userDto is a UserDto
     * @param point is an int
     * @return Boolean
     * @apiNote Method for giving point to an event
     */
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
                eventDto.setAverageRate(
                        ( eventDto.getAverageRate() * eventDto.getRateCount() + point ) / eventDto.getRateCount() + 1 );
                eventDto.setRateCount( eventDto.getRateCount() + 1 );
                eventRepository.save( modelMapper.map( eventDto,EventEntity.class ) );
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

    /**
     * Method for asking a question
     * @param eventDto is a EventDto
     * @param question is an String
     * @param userDto is a UserDto
     * @return Boolean
     * @apiNote Method for asking a question
     */
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

    /**
     * Method for responding to a question
     * @param eventQuestionDto is a EventQuestionDto
     * @param answer is an String
     * @return Boolean
     * @apiNote Method for responding to a question
     */
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

    /**
     * Method for getting an event by id
     * @param id is a long
     * @return EventDto
     * @apiNote Method for getting an event by id
     */
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

    /**
     * Method for getting an question by id
     * @param eventQuestionId is a long
     * @return EventQuestionDto
     * @apiNote Method for getting an question by id
     */
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

    /**
     * Method for getting an event participant by id
     * @param eventParticipantId is a long
     * @return EventParticipantDto
     * @apiNote Method for getting an event participant by id
     */
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

    /**
     * Method for getting an event participant by user and event
     * @param userEntity is a UserEntity
     * @param eventEntity is a EventEntity
     * @return EventParticipantDto
     * @apiNote Method for getting an event participant by user and event
     */
    @Override
    public EventParticipantDto getEventParticipantByUserAndEvent ( UserEntity userEntity , EventEntity eventEntity ) {
        try {
            Optional<EventParticipantEntity> optional =
                    eventParticipantRepository.findByUserAndEvent( userEntity , eventEntity );


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

    /**
     * Method for getting an event by code
     * @param code is a String
     * @return EventDto
     * @apiNote Method for getting an event by code
     */
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
