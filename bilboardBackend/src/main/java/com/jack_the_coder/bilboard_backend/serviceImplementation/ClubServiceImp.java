package com.jack_the_coder.bilboard_backend.serviceImplementation;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.repository.ClubRepository;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubDto;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubSponsorshipDto;
import com.jack_the_coder.bilboard_backend.shared.dto.EventDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImp implements ClubService {

    @Autowired
    ClubRepository clubRepository;

    @Override
    public ClubDto createClub ( ClubDto clubDto ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubEntity clubEntity = modelMapper.map( clubDto , ClubEntity.class );
        ClubEntity savedEntity = clubRepository.save( clubEntity );

        return modelMapper.map( savedEntity , ClubDto.class );
    }

    @Override
    public ClubDto getClub ( long clubId ) {
        return null;
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
}
