package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;

import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
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

    /**
     * Get id method
     * @return long
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id is an long parameter
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Get name method
     * @return String
     */
    public String getName () {
        return name;
    }

    /**
     * Set name method
     * @param name is String
     */
    public void setName ( String name ) {
        this.name = name;
    }

    /**
     * Get short name method
     * @return String
     */
    public String getShortName () {
        return shortName;
    }

    /**
     * Set short name method
     * @param shortName is String
     */
    public void setShortName ( String shortName ) {
        this.shortName = shortName;
    }

    /**
     * Get whatsapp link method
     * @return String
     */
    public String getWpLink () {
        return wpLink;
    }

    /**
     * Set whatsapp link method
     * @param wpLink is String
     */
    public void setWpLink ( String wpLink ) {
        this.wpLink = wpLink;
    }

    /**
     * Get instagram link method
     * @return String
     */
    public String getInstaLink () {
        return instaLink;
    }

    /**
     * Set instagram link method
     * @param instaLink is String
     */
    public void setInstaLink ( String instaLink ) {
        this.instaLink = instaLink;
    }

    /**
     * Get photo method
     * @return String
     */
    public String getPhoto () {
        return photo;
    }

    /**
     * Set photo method
     * @param photo is String
     */
    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    /**
     * Get president method
     * @return BasicUserResponse
     */
    public BasicUserResponse getPresident () {
        return president;
    }

    /**
     * Set president method
     * @param president is BasicUserResponse instance
     */
    public void setPresident (
            BasicUserResponse president ) {
        this.president = president;
    }

    /**
     * Get advisor method
     * @return BasicUserResponse
     */
    public BasicUserResponse getAdvisor () {
        return advisor;
    }

    /**
     * Set advisor method
     * @param advisor is BasicUserResponse instance
     */
    public void setAdvisor (
            BasicUserResponse advisor ) {
        this.advisor = advisor;
    }

    /**
     * Get club members method
     * @return ClubMemberResponse list
     */
    public List<ClubMemberResponse> getClubMembers () {
        return clubMembers;
    }

    /**
     * Set club members method
     * @param clubMembers is ClubMemberResponse list
     */
    public void setClubMembers (
            List<ClubMemberResponse> clubMembers ) {
        this.clubMembers = clubMembers;
    }

    /**
     * Get club board members method
     * @return ClubBoardMemberResponse list
     */
    public List<ClubBoardMemberResponse> getClubBoardMembers () {
        return clubBoardMembers;
    }

    /**
     * Set club board members method
     * @param clubBoardMembers is ClubBoardMemberResponse list
     */
    public void setClubBoardMembers (
            List<ClubBoardMemberResponse> clubBoardMembers ) {
        this.clubBoardMembers = clubBoardMembers;
    }

    /**
     * Get events method
     * @return EventResponse list
     */
    public List<EventResponse> getEvents () {
        return events;
    }

    /**
     * Set events method
     * @param events is EventResponse list
     */
    public void setEvents ( List<EventResponse> events ) {
        this.events = events;
    }

    /**
     * Get surveys method
     * @return SurveyResponse list
     */
    public List<SurveyResponse> getSurveys () {
        return surveys;
    }

    /**
     * Set surveys method
     * @param surveys is SurveyResponse list
     */
    public void setSurveys ( List<SurveyResponse> surveys ) {
        this.surveys = surveys;
    }

    /**
     * Get club feedbacks method
     * @return ClubFeedbackResponse list
     */
    public List<ClubFeedbackResponse> getClubFeedbacks () {
        return clubFeedbacks;
    }

    /**
     * Set club feedbacks method
     * @param clubFeedbacks is ClubFeedbackResponse list
     */
    public void setClubFeedbacks (
            List<ClubFeedbackResponse> clubFeedbacks ) {
        this.clubFeedbacks = clubFeedbacks;
    }

    /**
     * Get club sponsorships method
     * @return ClubSponsorshipResponse list
     */
    public List<ClubSponsorshipResponse> getClubSponsorships () {
        return clubSponsorships;
    }

    /**
     * Set club sponsorships method
     * @param clubSponsorships is ClubSponsorshipResponse list
     */
    public void setClubSponsorships (
            List<ClubSponsorshipResponse> clubSponsorships ) {
        this.clubSponsorships = clubSponsorships;
    }

    /**
     * Get enroll requests method
     * @return EnrollRequestResponse list
     */
    public List<EnrollRequestResponse> getEnrollRequests () {
        return enrollRequests;
    }

    /**
     * Set enroll requests method
     * @param enrollRequests is EnrollRequestResponse list
     */
    public void setEnrollRequests (
            List<EnrollRequestResponse> enrollRequests ) {
        this.enrollRequests = enrollRequests;
    }
}
