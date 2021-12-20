package com.jack_the_coder.bilboard_backend.serviceImplementation;

import com.jack_the_coder.bilboard_backend.exception.UserServiceException;
import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.ClubMemberEntity;
import com.jack_the_coder.bilboard_backend.io.entity.EnrollRequestEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import com.jack_the_coder.bilboard_backend.io.repository.ClubMemberRepository;
import com.jack_the_coder.bilboard_backend.io.repository.ClubRepository;
import com.jack_the_coder.bilboard_backend.io.repository.EnrollRequestRepository;
import com.jack_the_coder.bilboard_backend.io.repository.UserRepository;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.shared.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ClubSponsorshipDto addSponsorship ( ClubSponsorshipDto clubSponsorshipDto , long clubId ) {
        return null;
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
        return null;
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
}
