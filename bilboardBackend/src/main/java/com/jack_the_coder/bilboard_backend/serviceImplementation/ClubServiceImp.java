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
    ClubBoardMemberRepository clubBoardMemberRepository;

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
        clubEntity.setPhoto( "clubs/default.png" );

        ClubEntity savedEntity = clubRepository.save( clubEntity );

        return modelMapper.map( savedEntity , ClubDto.class );
    }

    @Override
    public ClubDto getClubById ( long clubId ) {
        try {
            Optional<ClubEntity> optionalClubEntity = clubRepository.findById( clubId );

            if ( optionalClubEntity.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map( optionalClubEntity.get() , ClubDto.class );
            } else {
                throw new UserServiceException( "Club is not found!" );
            }
        } catch ( Exception e ) {

            throw new UserServiceException( e.getMessage() );
        }
    }

    @Override
    public List<ClubDto> searchClub ( String name ) {
        try {
            ModelMapper modelMapper = new ModelMapper();

            List<ClubDto> clubDtoList = new ArrayList<>();
            clubRepository.findByNameContains( name ).forEach( clubEntity -> {
                clubDtoList.add( modelMapper.map( clubEntity,ClubDto.class ) );
            } );

            return clubDtoList;
        }catch ( Exception e ){
            throw new UserServiceException( e.getMessage() );
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
    public Boolean assignPresident ( UserDto userDto , ClubDto clubDto ) {
        try {
            ModelMapper modelMapper = new ModelMapper();

           if(userDto.getType().equals( UserEntity.UserTypes.student )){
               if ( userDto.getPresidentOf() != null ) {
                   userDto.getPresidentOf().setPresident( null );
                   clubRepository.save( userDto.getPresidentOf() );
               }

               if ( clubDto.getPresident() != null ) {
                   clubDto.getPresident().setPresidentOf( null );
                   userRepository.save( clubDto.getPresident() );
               }

               userDto.setPresidentOf( modelMapper.map( clubDto , ClubEntity.class ) );
               clubDto.setPresident( modelMapper.map( userDto , UserEntity.class ) );
               userRepository.save( modelMapper.map( userDto , UserEntity.class ) );
               clubRepository.save( modelMapper.map( clubDto , ClubEntity.class ) );
               return true;
           }else{
               throw new UserServiceException( "This is not a student!" );
           }
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
        }
    }

    @Override
    public Boolean assignAdvisor ( UserDto userDto , ClubDto clubDto ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            if ( userDto.getType().equals( UserEntity.UserTypes.academic ) ) {

                if ( userDto.getAdvisorOf() != null ) {
                    userDto.getAdvisorOf().setAdvisor( null );
                    clubRepository.save( userDto.getAdvisorOf() );
                }

                if ( clubDto.getAdvisor() != null ) {
                    clubDto.getAdvisor().setAdvisorOf( null );
                    userRepository.save( clubDto.getAdvisor() );
                }


                userDto.setAdvisorOf( modelMapper.map( clubDto , ClubEntity.class ) );
                clubDto.setAdvisor( modelMapper.map( userDto , UserEntity.class ) );
                userRepository.save( modelMapper.map( userDto , UserEntity.class ) );
                clubRepository.save( modelMapper.map( clubDto , ClubEntity.class ) );
                return true;
            } else {
                throw new UserServiceException( "This is not an academic user!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
        }
    }

    @Override
    public ClubSponsorshipDto getSponsorship ( long sponsorshipId ) {
        try {
            Optional<ClubSponsorshipEntity> optional = clubSponsorshipRepository.findById( sponsorshipId );

            if ( optional.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map( optional.get() , ClubSponsorshipDto.class );
            } else {
                throw new UserServiceException( "Record is NOT found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
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
            throw new UserServiceException( e.getMessage() );

        }
    }

    @Override
    public Boolean deleteSponsorship ( ClubSponsorshipDto clubSponsorshipDto ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            clubSponsorshipRepository.delete( modelMapper.map( clubSponsorshipDto , ClubSponsorshipEntity.class ) );
            return true;
        } catch ( Exception e ) {
            return false;
        }
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

            throw new UserServiceException( e.getMessage() );
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
            throw new UserServiceException( e.getMessage() );
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
                    if ( clubMemberRepository.findByClubAndUser( enrollRequestEntity.get().getClub() ,
                            enrollRequestEntity.get().getUser() ) == null ) {
                        clubMemberRepository.save( modelMapper.map( clubMemberDto , ClubMemberEntity.class ) );
                    } else {
                        throw new UserServiceException( "Record is already existing!" );
                    }
                }

                return true;
            } else {
                throw new UserServiceException( "Request is missing!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
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
            throw new UserServiceException( e.getMessage() );
        }
    }

    @Override
    public ClubMemberDto getMember ( long memberId ) {
        try {
            Optional<ClubMemberEntity> optional = clubMemberRepository.findById( memberId );

            if ( optional.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map( optional.get() , ClubMemberDto.class );
            } else {
                throw new UserServiceException( "Member record is not found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
        }
    }

    @Override
    public Boolean deleteMember ( ClubMemberDto clubMemberDto ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            clubMemberRepository.delete( modelMapper.map( clubMemberDto , ClubMemberEntity.class ) );
            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    @Override
    public ClubBoardMemberDto getBoardMember ( long boardMemberId ) {
        try {
            Optional<ClubBoardMemberEntity> optional = clubBoardMemberRepository.findById( boardMemberId );

            if ( optional.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map( optional.get() , ClubBoardMemberDto.class );
            } else {
                throw new UserServiceException( "BoardMember record is not found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
        }
    }

    @Override
    public ClubBoardMemberDto addBoardMember ( ClubBoardMemberDto clubBoardMemberDto ) {
        if ( clubBoardMemberRepository
                .findByClubAndUser( clubBoardMemberDto.getClub() , clubBoardMemberDto.getUser() ) == null ) {
            ModelMapper modelMapper = new ModelMapper();
            ClubBoardMemberEntity created = clubBoardMemberRepository.save( modelMapper.map( clubBoardMemberDto ,
                    ClubBoardMemberEntity.class ) );

            return modelMapper.map( created , ClubBoardMemberDto.class );
        } else {
            throw new UserServiceException( "Record is already exist!" );
        }
    }

    @Override
    public Boolean deleteBoardMember ( ClubBoardMemberDto clubBoardMemberDto ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            clubBoardMemberRepository.delete( modelMapper.map( clubBoardMemberDto , ClubBoardMemberEntity.class ) );
            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    @Override
    public ClubFeedbackDto getFeedback ( long feedbackId ) {
        try {
            Optional<ClubFeedbackEntity> optional = clubFeedbackRepository.findById( feedbackId );

            if ( optional.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map( optional.get() , ClubFeedbackDto.class );
            } else {
                throw new UserServiceException( "Feedback record is not found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
        }
    }

    @Override
    public ClubFeedbackDto createClubFeedback ( ClubFeedbackDto clubFeedbackDto ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubFeedbackEntity clubFeedbackEntity = modelMapper.map( clubFeedbackDto , ClubFeedbackEntity.class );
        ClubFeedbackEntity createdEntity = clubFeedbackRepository.save( clubFeedbackEntity );
        return modelMapper.map( createdEntity , ClubFeedbackDto.class );
    }

    @Override
    public Boolean respondFeedback ( ClubFeedbackDto clubFeedbackDto , boolean status ) {

        try {
            ModelMapper modelMapper = new ModelMapper();
            ClubFeedbackEntity clubFeedbackEntity = modelMapper.map( clubFeedbackDto , ClubFeedbackEntity.class );
            clubFeedbackEntity.setStatus( status );
            clubFeedbackRepository.save( clubFeedbackEntity );
            return true;
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
        }
    }

    @Override
    public List<ClubFeedbackDto> getFeedbacks ( long clubId ) {
        try {
            Optional<ClubEntity> optionalClubEntity = clubRepository.findById( clubId );

            if ( optionalClubEntity.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();
                List<ClubFeedbackDto> clubFeedbackDtoList = new ArrayList<>();

                optionalClubEntity.get().getClubFeedbacks().forEach( clubFeedbackEntity -> {
                    clubFeedbackDtoList.add( modelMapper.map( clubFeedbackEntity , ClubFeedbackDto.class ) );
                } );

                return clubFeedbackDtoList;
            } else {
                throw new UserServiceException( "Club is not found!" );
            }
        } catch ( Exception e ) {

            throw new UserServiceException( e.getMessage() );
        }
    }
}
