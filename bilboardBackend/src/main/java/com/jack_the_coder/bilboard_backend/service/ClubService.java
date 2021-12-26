package com.jack_the_coder.bilboard_backend.service;

import com.jack_the_coder.bilboard_backend.shared.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This class enables communication between controller and repository
 * @since 10.12.2021
 */
public interface ClubService {

    ClubDto createClub ( ClubDto clubDto );

    ClubDto getClubById ( long clubId );

    List<ClubDto> searchClub( String name );

    Boolean deleteClub ( long clubId );

    Boolean updateClub ( ClubDto clubDto );

    ClubSponsorshipDto getSponsorship ( long sponsorshipId );

    ClubSponsorshipDto addSponsorship ( long clubId , String name , MultipartFile photo , int amount , String type );

    Boolean deleteSponsorship ( ClubSponsorshipDto clubSponsorshipDto );

    Boolean assignPresident ( UserDto userDto , ClubDto clubDto );

    Boolean assignAdvisor ( UserDto userDto , ClubDto clubDto );

    List<EventDto> getEvents ( long clubId );

    Boolean updatePhoto ( long clubId , MultipartFile photo );

    Boolean enrollClub ( long userId , long clubId );

    Boolean respondEnrollRequest ( long enrollmentId , String status );

    ClubMemberDto getMember ( long memberId );

    Boolean deleteMember ( ClubMemberDto clubMemberDto );

    ClubBoardMemberDto getBoardMember ( long boardMemberId );

    ClubBoardMemberDto addBoardMember ( ClubBoardMemberDto clubBoardMemberDto );

    Boolean deleteBoardMember ( ClubBoardMemberDto clubBoardMemberDto );

    ClubFeedbackDto getFeedback ( long feedbackId );

    ClubFeedbackDto createClubFeedback ( ClubFeedbackDto clubFeedbackDto );

    Boolean respondFeedback ( ClubFeedbackDto clubFeedbackDto , boolean status );

    List<ClubFeedbackDto> getFeedbacks ( long clubId );
}
