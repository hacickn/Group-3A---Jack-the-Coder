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
    private List<SurveyResponse> surveyParticipants;
    private List<EventQuestionResponse> eventQuestions;
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

    public String getSurname () {
        return surname;
    }

    public void setSurname ( String surname ) {
        this.surname = surname;
    }

    public UserEntity.UserTypes getType () {
        return type;
    }

    public void setType ( UserEntity.UserTypes type ) {
        this.type = type;
    }

    public String getBilkentId () {
        return bilkentId;
    }

    public void setBilkentId ( String bilkentId ) {
        this.bilkentId = bilkentId;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public boolean isGeTaken () {
        return geTaken;
    }

    public void setGeTaken ( boolean geTaken ) {
        this.geTaken = geTaken;
    }

    public String getPhoto () {
        return photo;
    }

    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    public BasicClubResponse getPresidentOf () {
        return presidentOf;
    }

    public void setPresidentOf (
            BasicClubResponse presidentOf ) {
        this.presidentOf = presidentOf;
    }

    public BasicClubResponse getAdvisorOf () {
        return advisorOf;
    }

    public void setAdvisorOf (
            BasicClubResponse advisorOf ) {
        this.advisorOf = advisorOf;
    }

    public List<ClubMemberResponse> getClubMemberShips () {
        return clubMemberShips;
    }

    public void setClubMemberShips (
            List<ClubMemberResponse> clubMemberShips ) {
        this.clubMemberShips = clubMemberShips;
    }

    public List<ClubBoardMemberResponse> getClubBoardMemberships () {
        return clubBoardMemberships;
    }

    public void setClubBoardMemberships (
            List<ClubBoardMemberResponse> clubBoardMemberships ) {
        this.clubBoardMemberships = clubBoardMemberships;
    }

    public List<EventParticipantResponse> getEventParticipants () {
        return eventParticipants;
    }

    public void setEventParticipants (
            List<EventParticipantResponse> eventParticipants ) {
        this.eventParticipants = eventParticipants;
    }

    public List<ClubFeedbackResponse> getClubFeedbacks () {
        return clubFeedbacks;
    }

    public void setClubFeedbacks (
            List<ClubFeedbackResponse> clubFeedbacks ) {
        this.clubFeedbacks = clubFeedbacks;
    }

    public List<SurveyResponse> getSurveyParticipants () {
        return surveyParticipants;
    }

    public void setSurveyParticipants (
            List<SurveyResponse> surveyParticipants ) {
        this.surveyParticipants = surveyParticipants;
    }

    public List<EventQuestionResponse> getEventQuestions () {
        return eventQuestions;
    }

    public void setEventQuestions (
            List<EventQuestionResponse> eventQuestions ) {
        this.eventQuestions = eventQuestions;
    }

    public List<EnrollRequestResponse> getEnrollRequests () {
        return enrollRequests;
    }

    public void setEnrollRequests (
            List<EnrollRequestResponse> enrollRequests ) {
        this.enrollRequests = enrollRequests;
    }
}
