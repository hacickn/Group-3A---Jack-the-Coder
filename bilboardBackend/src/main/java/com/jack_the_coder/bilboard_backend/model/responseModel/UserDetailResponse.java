package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;

import java.util.List;

public class UserDetailResponse {

    private long id;
    private String name;
    private String surname;
    private UserEntity.UserTypes type;
    private String bilkentId;
    private String email;
    private boolean geTaken;
    private String photo;
    private BasicClubResponse presidentOf;
    private BasicClubResponse advisorOf;
    private List<ClubMemberResponse> clubMemberShips;
    private List<ClubBoardMemberResponse> clubBoardMemberships;
    private List<EventParticipantResponse> eventParticipants;
    private List<ClubFeedbackResponse> clubFeedbacks;
    private List<SurveyParticipantResponse> surveyParticipants;
    private List<EventQuestionResponse> eventQuestions;
    private List<EnrollRequestResponse> enrollRequests;
    private List<EventResponse> discover;
    private List<EventResponse> followingClubsEvents;
    private List<EventResponse> futureEvents;
    private List<EventResponse> pastEvents;

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
     * Get surname method
     * @return String
     */
    public String getSurname () {
        return surname;
    }

    /**
     * Set surname method
     * @param surname is String
     */
    public void setSurname ( String surname ) {
        this.surname = surname;
    }

    /**
     * Get type method
     * @return UserEntity.UserTypes
     */
    public UserEntity.UserTypes getType () {
        return type;
    }

    /**
     * Set type method
     * @param type is UserEntity.UserTypes
     */
    public void setType ( UserEntity.UserTypes type ) {
        this.type = type;
    }

    /**
     * Get bilkentId method
     * @return String
     */
    public String getBilkentId () {
        return bilkentId;
    }

    /**
     * Set bilkentId method
     * @param bilkentId is String
     */
    public void setBilkentId ( String bilkentId ) {
        this.bilkentId = bilkentId;
    }

    /**
     * Get email method
     * @return String
     */
    public String getEmail () {
        return email;
    }

    /**
     * Set email method
     * @param email is String
     */
    public void setEmail ( String email ) {
        this.email = email;
    }

    /**
     * Get geTaken method
     * @return boolean
     */
    public boolean isGeTaken () {
        return geTaken;
    }

    /**
     * Set geTaken method
     * @param geTaken is boolean
     */
    public void setGeTaken ( boolean geTaken ) {
        this.geTaken = geTaken;
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
     * Get presidentOf method
     * @return BasicClubResponse
     */
    public BasicClubResponse getPresidentOf () {
        return presidentOf;
    }

    /**
     * Set presidentOf method
     * @param presidentOf is BasicClubResponse
     */
    public void setPresidentOf (
            BasicClubResponse presidentOf ) {
        this.presidentOf = presidentOf;
    }

    /**
     * Get advisorOf method
     * @return BasicClubResponse
     */
    public BasicClubResponse getAdvisorOf () {
        return advisorOf;
    }

    /**
     * Set advisorOf method
     * @param advisorOf is BasicClubResponse
     */
    public void setAdvisorOf (
            BasicClubResponse advisorOf ) {
        this.advisorOf = advisorOf;
    }

    /**
     * Get clubMemberShips method
     * @return List<ClubMemberResponse>
     */
    public List<ClubMemberResponse> getClubMemberShips () {
        return clubMemberShips;
    }

    /**
     * Set clubMemberShips method
     * @param clubMemberShips is List<ClubMemberResponse>
     */
    public void setClubMemberShips (
            List<ClubMemberResponse> clubMemberShips ) {
        this.clubMemberShips = clubMemberShips;
    }

    /**
     * Get clubBoardMemberships method
     * @return List<ClubBoardMemberResponse>
     */
    public List<ClubBoardMemberResponse> getClubBoardMemberships () {
        return clubBoardMemberships;
    }

    /**
     * Set clubBoardMemberships method
     * @param clubBoardMemberships is List<ClubBoardMemberResponse>
     */
    public void setClubBoardMemberships (
            List<ClubBoardMemberResponse> clubBoardMemberships ) {
        this.clubBoardMemberships = clubBoardMemberships;
    }

    /**
     * Get eventParticipants method
     * @return List<EventParticipantResponse>
     */
    public List<EventParticipantResponse> getEventParticipants () {
        return eventParticipants;
    }

    /**
     * Set eventParticipants method
     * @param eventParticipants is List<EventParticipantResponse>
     */
    public void setEventParticipants (
            List<EventParticipantResponse> eventParticipants ) {
        this.eventParticipants = eventParticipants;
    }

    /**
     * Get clubFeedbacks method
     * @return List<ClubFeedbackResponse>
     */
    public List<ClubFeedbackResponse> getClubFeedbacks () {
        return clubFeedbacks;
    }

    /**
     * Set clubFeedbacks method
     * @param clubFeedbacks is List<ClubFeedbackResponse>
     */
    public void setClubFeedbacks (
            List<ClubFeedbackResponse> clubFeedbacks ) {
        this.clubFeedbacks = clubFeedbacks;
    }

    /**
     * Get surveyParticipants method
     * @return List<SurveyParticipantResponse>
     */
    public List<SurveyParticipantResponse> getSurveyParticipants () {
        return surveyParticipants;
    }

    /**
     * Set surveyParticipants method
     * @param surveyParticipants is List<SurveyParticipantResponse>
     */
    public void setSurveyParticipants (
            List<SurveyParticipantResponse> surveyParticipants ) {
        this.surveyParticipants = surveyParticipants;
    }

    /**
     * Get discover method
     * @return List<EventQuestionResponse>
     */
    public List<EventQuestionResponse> getEventQuestions () {
        return eventQuestions;
    }

    /**
     * Set event questions method
     * @param eventQuestions is List<EventQuestionResponse>
     */
    public void setEventQuestions (
            List<EventQuestionResponse> eventQuestions ) {
        this.eventQuestions = eventQuestions;
    }

    /**
     * Get enrollRequests method
     * @return List<EventQuestionResponse>
     */
    public List<EnrollRequestResponse> getEnrollRequests () {
        return enrollRequests;
    }

    /**
     * Set enroll requests method
     * @param enrollRequests is List<EnrollRequestResponse>
     */
    public void setEnrollRequests (
            List<EnrollRequestResponse> enrollRequests ) {
        this.enrollRequests = enrollRequests;
    }

    /**
     * Get discover method
     * @return List<EventResponse>
     */
    public List<EventResponse> getDiscover () {
        return discover;
    }

    /**
     * Set discover method
     * @param discover is List<EventResponse>
     */
    public void setDiscover ( List<EventResponse> discover ) {
        this.discover = discover;
    }

    /**
     * Get following clubs events method
     * @return List<EventResponse>
     */
    public List<EventResponse> getFollowingClubsEvents () {
        return followingClubsEvents;
    }

    /**
     * Set following clubs events method
     * @param followingClubsEvents is List<EventResponse>
     */
    public void setFollowingClubsEvents (
            List<EventResponse> followingClubsEvents ) {
        this.followingClubsEvents = followingClubsEvents;
    }

    /**
     * Get futureEvents method
     * @return List<EventResponse>
     */
    public List<EventResponse> getFutureEvents () {
        return futureEvents;
    }

    /**
     * Set future events method
     * @param futureEvents is List<EventResponse>
     */
    public void setFutureEvents (
            List<EventResponse> futureEvents ) {
        this.futureEvents = futureEvents;
    }

    /**
     * Get pastEvents method
     * @return List<EventResponse>
     */
    public List<EventResponse> getPastEvents () {
        return pastEvents;
    }

    /**
     * Set past events method
     * @param pastEvents is List<EventResponse>
     */
    public void setPastEvents (
            List<EventResponse> pastEvents ) {
        this.pastEvents = pastEvents;
    }
}
