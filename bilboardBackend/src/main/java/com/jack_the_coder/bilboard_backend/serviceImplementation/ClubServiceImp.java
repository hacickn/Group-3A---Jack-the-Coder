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

/**
 * @author Hacı Çakın
 * @apiNote This class enables communication between controller and repository
 * @since 10.12.2021
 */
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

    /**
     * Method for creating a club
     * @param clubDto is a ClubDto
     * @return ClubDto
     * @apiNote Method for creating a club.
     */
    @Override
    public ClubDto createClub ( ClubDto clubDto ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubEntity clubEntity = modelMapper.map( clubDto , ClubEntity.class );
        clubEntity.setPhoto( "clubs/default.png" );

        ClubEntity savedEntity = clubRepository.save( clubEntity );

        return modelMapper.map( savedEntity , ClubDto.class );
    }

    /**
     * Method for get a ClubDto with specifying index
     * @param clubId is a long
     * @return ClubDto
     * @apiNote Method for get a ClubDto with specifying index.
     */
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

    /**
     * Method for searching a list of ClubDto with specifying common name
     * @param name is a String
     * @return List<ClubDto>
     * @apiNote Method for searching a list of ClubDto with specifying common name.
     */
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

    /**
     * Method for deleting a club with specifying the id of the club
     * @param clubId is a long
     * @return Boolean
     * @apiNote Method for deleting a club with specifying the id of the club
     */
    @Override
    public Boolean deleteClub ( long clubId ) {
        return null;
    }

    /**
     * Method for updating a club with specifying a clubDto
     * @param clubId is a long
     * @return Boolean
     * @apiNote Method for deleting a club with specifying the id of the club
     */
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

    /**
     * Method for assigning a president to the club with specifying a clubDto and userDto
     * @param userDto is a UserDto
     * @param clubDto is a ClubDto
     * @return Boolean
     * @apiNote Method for assigning a president to the club with specifying a clubDto and userDto
     */
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

    /**
     * Method for assigning a advisor to the club with specifying a clubDto and userDto
     * @param userDto is a UserDto
     * @param clubDto is a ClubDto
     * @return Boolean
     * @apiNote Method for assigning a advisor to the club with specifying a clubDto and userDto
     */
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

    /**
     * Method for getting a sponsorship of the club with specifying sponsorship's ID
     * @param sponsorshipId is a long
     * @return ClubSponsorshipDto
     * @apiNote Method for getting a sponsorship of the club with specifying sponsorship's ID
     */
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

    /**
     * Method for adding a new sponsorship to the club
     * @param clubId is a long
     * @param name is a String
     * @param photo is a MultipartFile
     * @param amount is a int
     * @param type is a String
     * @return ClubSponsorshipDto
     * @apiNote Method for adding a new sponsorship to the club
     */
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

    /**
     * Method for deleting a sponsorship to the club
     * @param clubSponsorshipDto is a ClubSponsorshipDto
     * @return Boolean
     * @apiNote Method for deleting a sponsorship to the club
     */
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

    /**
     * Method for getting events of a club
     * @param clubId is a long
     * @return List<EventDto>
     * @apiNote Method for getting events of a club
     */
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

    /**
     * Method for enroll to a club
     * @param userId is a long
     * @param clubId is a long
     * @return Boolean
     * @apiNote Method for enroll to a club
     */
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

    /**
     * Method for responding to a enroll request
     * @param enrollmentId is a long
     * @param status is a String
     * @return Boolean
     * @apiNote Method for responding to a enroll request
     */
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

    /**
     * Method for updating the photo of the club
     * @param clubId is a long
     * @param photo is a Multipartfile
     * @return Boolean
     * @apiNote Method for updating the photo of the club
     */
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

    /**
     * Method for getting a member of a club
     * @param memberId is a long
     * @return ClubMemberDto
     * @apiNote Method for getting a member of a club
     */
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

    /**
     * Method for deleting a member of a club
     * @param clubMemberDto is a ClubMemberDto
     * @return Boolean
     * @apiNote Method for deleting a member of a club
     */
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

    /**
     * Method for getting a board member of a club
     * @param boardMemberId is a long
     * @return ClubBoardMemberDto
     * @apiNote Method for getting a board member of a club
     */
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

    /**
     * Method for adding a board member to a club
     * @param clubBoardMemberDto is a ClubBoardMemberDto
     * @return ClubBoardMemberDto
     * @apiNote Method for adding a board member to a club
     */
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

    /**
     * Method for deleting a board member of a club
     * @param clubBoardMemberDto is a ClubBoardMemberDto
     * @return Boolean
     * @apiNote Method for deleting a board member of a club
     */
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

    /**
     * Method for getting a feedback of a club
     * @param feedbackId is a long
     * @return ClubFeedbackDto
     * @apiNote Method for getting a feedback of a club
     */
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

    /**
     * Method for creating a feedback to a club
     * @param clubFeedbackDto is a ClubFeedbackDto
     * @return ClubFeedbackDto
     * @apiNote Method for creating a feedback to a club
     */
    @Override
    public ClubFeedbackDto createClubFeedback ( ClubFeedbackDto clubFeedbackDto ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubFeedbackEntity clubFeedbackEntity = modelMapper.map( clubFeedbackDto , ClubFeedbackEntity.class );
        ClubFeedbackEntity createdEntity = clubFeedbackRepository.save( clubFeedbackEntity );
        return modelMapper.map( createdEntity , ClubFeedbackDto.class );
    }

    /**
     * Method for responding a feedback of a club
     * @param clubFeedbackDto is a ClubFeedbackDto
     * @param status is a boolean
     * @return Boolean
     * @apiNote Method for responding a feedback of a club
     */
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

    /**
     * Method for getting feedbacks of a club
     * @param clubId is a long
     * @return List<ClubFeedbackDto>
     * @apiNote Method for getting feedbacks of a club
     */
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
