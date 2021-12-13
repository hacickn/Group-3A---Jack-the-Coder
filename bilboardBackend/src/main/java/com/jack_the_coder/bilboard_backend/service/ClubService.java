package com.jack_the_coder.bilboard_backend.service;

import com.jack_the_coder.bilboard_backend.shared.dto.ClubDto;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubSponsorshipDto;
import com.jack_the_coder.bilboard_backend.shared.dto.EventDto;

import java.util.List;

public interface ClubService {

    ClubDto createClub ( ClubDto clubDto );

    ClubDto getClub ( long clubId );

    Boolean deleteClub ( long clubId );

    Boolean updateClub ( ClubDto clubDto );

    ClubSponsorshipDto addSponsorship ( ClubSponsorshipDto clubSponsorshipDto , long clubId );

    Boolean deleteSponsorship ( long sponsorshipId );

    Boolean changePresident ( long userId , long clubId );

    Boolean changeAdvisor ( long userId , long clubId );

    List<EventDto> getEvents ( long clubId );

}
