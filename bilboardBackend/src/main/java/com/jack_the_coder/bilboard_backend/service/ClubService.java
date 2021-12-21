package com.jack_the_coder.bilboard_backend.service;

import com.jack_the_coder.bilboard_backend.shared.dto.ClubDto;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubFeedbackDto;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubSponsorshipDto;
import com.jack_the_coder.bilboard_backend.shared.dto.EventDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClubService {

    ClubDto createClub ( ClubDto clubDto );

    ClubDto getClub ( long clubId );

    Boolean deleteClub ( long clubId );

    Boolean updateClub ( ClubDto clubDto );

    Boolean deleteSponsorship ( long sponsorshipId );

    Boolean changePresident ( long userId , long clubId );

    Boolean changeAdvisor ( long userId , long clubId );

    List<EventDto> getEvents ( long clubId );

    Boolean updatePhoto ( long clubId , MultipartFile photo );

    Boolean enrollClub ( long userId , long clubId );

    Boolean respondEnrollRequest ( long enrollmentId , String status );

    ClubSponsorshipDto addSponsorship ( long clubId , String name , MultipartFile photo , int amount , String type );

    ClubFeedbackDto createClubFeedback ( ClubFeedbackDto clubFeedbackDto);

}
