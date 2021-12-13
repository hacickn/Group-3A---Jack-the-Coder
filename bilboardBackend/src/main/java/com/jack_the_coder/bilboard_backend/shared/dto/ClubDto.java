package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author Hacı Çakın and Aslı Dinç
 * @apiNote This class is data transfer object of the clubs
 * @implNote NOT Completed
 * @since 13.12.2021
 */
public class ClubDto implements Serializable {

    // todo
    private static final long serialVersionUID = -7004077156911053223L;
    private long id;
    private String name;
    private String shortName;
    private String wpLink;
    private String instaLink;
    private String photo;
    private UserEntity president;
    private UserEntity advisor;
    private List<ClubMemberEntity> clubMembers;
    private List<ClubBoardMemberEntity> clubBoardMembers;
    private List<EventEntity> events;
    private List<SurveyEntity> surveys;
    private UniversityEntity university;
    private List<ClubFeedbackEntity> clubFeedbacks;
    private List<ClubSponsorshipEntity> clubSponsorships;
    private List<EnrollRequestEntity> enrollRequests;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getShortName () {
        return shortName;
    }

    public void setShortName ( String shortName ) {
        this.shortName = shortName;
    }

    public String getWpLink () {
        return wpLink;
    }

    public void setWpLink ( String wpLink ) {
        this.wpLink = wpLink;
    }

    public String getInstaLink () {
        return instaLink;
    }

    public void setInstaLink ( String instaLink ) {
        this.instaLink = instaLink;
    }

    public String getPhoto () {
        return photo;
    }

    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    public UserEntity getPresident () {
        return president;
    }

    public void setPresident ( UserEntity president ) {
        this.president = president;
    }

    public UserEntity getAdvisor () {
        return advisor;
    }

    public void setAdvisor ( UserEntity advisor ) {
        this.advisor = advisor;
    }

    public List<ClubMemberEntity> getClubMembers () {
        return clubMembers;
    }

    public void setClubMembers ( List<ClubMemberEntity> clubMembers ) {
        this.clubMembers = clubMembers;
    }

    public List<ClubBoardMemberEntity> getClubBoardMembers () {
        return clubBoardMembers;
    }

    public void setClubBoardMembers (
            List<ClubBoardMemberEntity> clubBoardMembers ) {
        this.clubBoardMembers = clubBoardMembers;
    }

    public List<EventEntity> getEvents () {
        return events;
    }

    public void setEvents ( List<EventEntity> events ) {
        this.events = events;
    }

    public List<SurveyEntity> getSurveys () {
        return surveys;
    }

    public void setSurveys ( List<SurveyEntity> surveys ) {
        this.surveys = surveys;
    }

    public UniversityEntity getUniversity () {
        return university;
    }

    public void setUniversity ( UniversityEntity university ) {
        this.university = university;
    }

    public List<ClubFeedbackEntity> getClubFeedbacks () {
        return clubFeedbacks;
    }

    public void setClubFeedbacks (
            List<ClubFeedbackEntity> clubFeedbacks ) {
        this.clubFeedbacks = clubFeedbacks;
    }

    public List<ClubSponsorshipEntity> getClubSponsorships () {
        return clubSponsorships;
    }

    public void setClubSponsorships (
            List<ClubSponsorshipEntity> clubSponsorships ) {
        this.clubSponsorships = clubSponsorships;
    }

    public List<EnrollRequestEntity> getEnrollRequests () {
        return enrollRequests;
    }

    public void setEnrollRequests (
            List<EnrollRequestEntity> enrollRequests ) {
        this.enrollRequests = enrollRequests;
    }
}
