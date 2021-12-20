package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;

import java.util.List;

public class ClubResponse {
    private long id;
    private String name;
    private String shortName;
    private String wpLink;
    private String instaLink;
    private String photo;
    private BasicUserResponse president;
    private BasicUserResponse advisor;
    private List<ClubMemberResponse> clubMembers;
    private List<ClubBoardMemberResponse> clubBoardMembers;
    private List<EventResponse> events;
    private List<SurveyResponse> surveys;
    private List<ClubFeedbackResponse> clubFeedbacks;
    private List<ClubSponsorshipResponse> clubSponsorships;
    private List<EnrollRequestResponse> enrollRequests;

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

    public BasicUserResponse getPresident () {
        return president;
    }

    public void setPresident (
            BasicUserResponse president ) {
        this.president = president;
    }

    public BasicUserResponse getAdvisor () {
        return advisor;
    }

    public void setAdvisor (
            BasicUserResponse advisor ) {
        this.advisor = advisor;
    }

    public List<ClubMemberResponse> getClubMembers () {
        return clubMembers;
    }

    public void setClubMembers (
            List<ClubMemberResponse> clubMembers ) {
        this.clubMembers = clubMembers;
    }

    public List<ClubBoardMemberResponse> getClubBoardMembers () {
        return clubBoardMembers;
    }

    public void setClubBoardMembers (
            List<ClubBoardMemberResponse> clubBoardMembers ) {
        this.clubBoardMembers = clubBoardMembers;
    }

    public List<EventResponse> getEvents () {
        return events;
    }

    public void setEvents ( List<EventResponse> events ) {
        this.events = events;
    }

    public List<SurveyResponse> getSurveys () {
        return surveys;
    }

    public void setSurveys ( List<SurveyResponse> surveys ) {
        this.surveys = surveys;
    }

    public List<ClubFeedbackResponse> getClubFeedbacks () {
        return clubFeedbacks;
    }

    public void setClubFeedbacks (
            List<ClubFeedbackResponse> clubFeedbacks ) {
        this.clubFeedbacks = clubFeedbacks;
    }

    public List<ClubSponsorshipResponse> getClubSponsorships () {
        return clubSponsorships;
    }

    public void setClubSponsorships (
            List<ClubSponsorshipResponse> clubSponsorships ) {
        this.clubSponsorships = clubSponsorships;
    }

    public List<EnrollRequestResponse> getEnrollRequests () {
        return enrollRequests;
    }

    public void setEnrollRequests (
            List<EnrollRequestResponse> enrollRequests ) {
        this.enrollRequests = enrollRequests;
    }
}
