package com.jack_the_coder.bilboard_backend.serviceImplementation;

import com.jack_the_coder.bilboard_backend.exception.UserServiceException;
import com.jack_the_coder.bilboard_backend.io.entity.*;
import com.jack_the_coder.bilboard_backend.io.repository.*;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.service.StorageService;
import com.jack_the_coder.bilboard_backend.shared.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImp implements ClubService {

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EnrollRequestRepository enrollRequestRepository;

    @Autowired
    ClubMemberRepository clubMemberRepository;

    @Autowired
    ClubSponsorshipRepository clubSponsorshipRepository;

    @Autowired
    ClubFeedbackRepository clubFeedbackRepository;

    @Autowired
    StorageService storageService;

    @Override
    public ClubDto createClub ( ClubDto clubDto ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubEntity clubEntity = modelMapper.map( clubDto , ClubEntity.class );
        ClubEntity savedEntity = clubRepository.save( clubEntity );

        return modelMapper.map( savedEntity , ClubDto.class );
    }

    @Override
    public ClubDto getClub ( long clubId ) {
        try {
            Optional<ClubEntity> optionalClubEntity = clubRepository.findById( clubId );

            if ( optionalClubEntity.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map( optionalClubEntity.get() , ClubDto.class );
            } else {
                throw new UserServiceException( "Club is not found!" );
            }
        } catch ( Exception e ) {

            throw new UserServiceException( "Club is not found!" );
        }
    }

    @Override
    public Boolean deleteClub ( long clubId ) {
        return null;
    }

    @Override
    public Boolean updateClub ( ClubDto clubDto ) {
        try {
            Optional<ClubEntity> optionalClubEntity = clubRepository.findById( clubDto.getId() );

            if ( optionalClubEntity.isPresent() ) {
                ClubEntity clubEntity = optionalClubEntity.get();
                clubEntity.setName( clubDto.getName() );
                clubEntity.setShortName( clubDto.getShortName() );
                clubEntity.setWpLink( clubDto.getWpLink() );
                clubEntity.setInstaLink( clubDto.getInstaLink() );
                clubRepository.save( clubEntity );

                return true;
            } else {

                return false;
            }
        } catch ( Exception e ) {

            return false;
        }
    }

    @Override
    public Boolean deleteSponsorship ( long sponsorshipId ) {
        return null;
    }

    @Override
    public Boolean changePresident ( long userId , long clubId ) {
        return null;
    }

    @Override
    public Boolean changeAdvisor ( long userId , long clubId ) {
        return null;
    }

    @Override
    public List<EventDto> getEvents ( long clubId ) {
        try {
            Optional<ClubEntity> optionalClubEntity = clubRepository.findById( clubId );

            if ( optionalClubEntity.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                List<EventDto> eventDtoList = new ArrayList<>();

                optionalClubEntity.get().getEvents().forEach( eventEntity -> {
                    eventDtoList.add( modelMapper.map( eventEntity , EventDto.class ) );
                } );

                return eventDtoList;
            } else {
                throw new UserServiceException( "Club is not found!" );
            }
        } catch ( Exception e ) {

            throw new UserServiceException( "Club is not found!" );
        }
    }

    @Override
    public Boolean enrollClub ( long userId , long clubId ) {
        try {
            Optional<UserEntity> userEntity = userRepository.findById( userId );
            Optional<ClubEntity> clubEntity = clubRepository.findById( clubId );
            if ( userEntity.isPresent() && clubEntity.isPresent() ) {
                if ( enrollRequestRepository.findByUserAndClub( userEntity.get() , clubEntity.get() ) == null ) {
                    ModelMapper modelMapper = new ModelMapper();
                    EnrollRequestDto enrollRequestDto = new EnrollRequestDto();
                    enrollRequestDto.setClub( clubEntity.get() );
                    enrollRequestDto.setUser( userEntity.get() );
                    enrollRequestDto.setCreatedAt( new Date() );
                    enrollRequestDto.setStatus( EnrollRequestEntity.RequestStatus.created );
                    enrollRequestRepository.save( modelMapper.map( enrollRequestDto ,
                            EnrollRequestEntity.class ) );
                    return true;
                } else {
                    throw new UserServiceException( "Enroll request already created!" );

                }
            } else {
                throw new UserServiceException( "User or club is missing!" );
            }

        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong. Try it later!" );
        }
    }

    @Override
    public Boolean respondEnrollRequest ( long enrollmentId , String status ) {
        try {
            Optional<EnrollRequestEntity> enrollRequestEntity = enrollRequestRepository.findById( enrollmentId );

            if ( enrollRequestEntity.isPresent() ) {
                enrollRequestEntity.get().setStatus( EnrollRequestEntity.RequestStatus.valueOf( status ) );
                enrollRequestRepository.save( enrollRequestEntity.get() );

                if ( status.equals( "accepted" ) ) {
                    ModelMapper modelMapper = new ModelMapper();
                    ClubMemberDto clubMemberDto = new ClubMemberDto();
                    clubMemberDto.setUser( enrollRequestEntity.get().getUser() );
                    clubMemberDto.setClub( enrollRequestEntity.get().getClub() );
                    clubMemberDto.setAttendedEventCount( 0 );
                    clubMemberDto.setGePoint( 0 );
                    clubMemberRepository.save( modelMapper.map( clubMemberDto , ClubMemberEntity.class ) );
                }

                return true;
            } else {
                throw new UserServiceException( "Request is missing!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong. Try it later!" );
        }
    }

    @Override
    public Boolean updatePhoto ( long clubId , MultipartFile photo ) {
        try {
            Optional<ClubEntity> optionalClubEntity = clubRepository.findById( clubId );
            if ( optionalClubEntity.isPresent() ) {
                String newPath = storageService.saveProfilePhoto( photo , "clubs" , clubId );
                optionalClubEntity.get().setPhoto( newPath );
                clubRepository.save( optionalClubEntity.get() );
                return true;
            } else {
                throw new UserServiceException( "Club is not found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    @Override
    public ClubSponsorshipDto addSponsorship ( long clubId , String name , MultipartFile photo , int amount ,
                                               String type ) {
        try {
            Optional<ClubEntity> optionalClubEntity = clubRepository.findById( clubId );
            if ( optionalClubEntity.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                ClubSponsorshipDto clubSponsorshipDto = new ClubSponsorshipDto();
                clubSponsorshipDto.setName( name );
                clubSponsorshipDto.setClub( optionalClubEntity.get() );
                clubSponsorshipDto.setAmount( amount );
                clubSponsorshipDto.setType( type );
                ClubSponsorshipEntity created = clubSponsorshipRepository.save( modelMapper.map( clubSponsorshipDto ,
                        ClubSponsorshipEntity.class ) );
                String newPath = storageService.saveProfilePhoto( photo , "sponsors" , created.getId() );
                created.setPhoto( newPath );
                ClubSponsorshipEntity saved = clubSponsorshipRepository.save( created );
                return modelMapper.map( saved , ClubSponsorshipDto.class );
            } else {
                throw new UserServiceException( "Club is not found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );

        }
    }

    @Override
    public ClubFeedbackDto createClubFeedback ( ClubFeedbackDto clubFeedbackDto ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubFeedbackEntity clubFeedbackEntity = modelMapper.map( clubFeedbackDto, ClubFeedbackEntity.class );
        ClubFeedbackEntity createdEntity = clubFeedbackRepository.save( clubFeedbackEntity );
        return modelMapper.map( createdEntity, ClubFeedbackDto.class );
    }
}
