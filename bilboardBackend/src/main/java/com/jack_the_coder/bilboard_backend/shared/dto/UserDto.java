package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın and Aslı Dinç
 * @apiNote This class is data transfer object of the users
 * @implNote NOT Completed
 * @since 12.12.2021
 */
public class UserDto implements Serializable {

    // todo
    private static final long serialVersionUID = 5322786870704152401L;
    private long id;
    private String name;
    private String surname;
    private UserEntity.UserTypes type;
    private String password;
    private String bilkentId;
    private String email;
    private boolean geTaken;
    private boolean emailConfirmation = false;
    private String emailConfirmationToken;
    private Date jwtExpirationTime;
    private ClubEntity presidentOf;
    private ClubEntity advisorOf;
    private List<ClubMemberEntity> clubMemberShips;
    private List<ClubBoardMemberEntity> clubBoardMemberships;
    private UniversityEntity university;
    private List<EventParticipantEntity> eventParticipants;
    private List<ClubFeedbackEntity> clubFeedbacks;
    private List<SurveyParticipantEntity> surveyParticipants;
    private List<EventQuestionEntity> eventQuestions;
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

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
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

    public boolean isEmailConfirmation () {
        return emailConfirmation;
    }

    public void setEmailConfirmation ( boolean emailConfirmation ) {
        this.emailConfirmation = emailConfirmation;
    }

    public String getEmailConfirmationToken () {
        return emailConfirmationToken;
    }

    public void setEmailConfirmationToken ( String emailConfirmationToken ) {
        this.emailConfirmationToken = emailConfirmationToken;
    }

    public Date getJwtExpirationTime () {
        return jwtExpirationTime;
    }

    public void setJwtExpirationTime ( Date jwtExpirationTime ) {
        this.jwtExpirationTime = jwtExpirationTime;
    }

    public ClubEntity getPresidentOf () {
        return presidentOf;
    }

    public void setPresidentOf ( ClubEntity presidentOf ) {
        this.presidentOf = presidentOf;
    }

    public ClubEntity getAdvisorOf () {
        return advisorOf;
    }

    public void setAdvisorOf ( ClubEntity advisorOf ) {
        this.advisorOf = advisorOf;
    }

    public List<ClubMemberEntity> getClubMemberShips () {
        return clubMemberShips;
    }

    public void setClubMemberShips (
            List<ClubMemberEntity> clubMemberShips ) {
        this.clubMemberShips = clubMemberShips;
    }

    public List<ClubBoardMemberEntity> getClubBoardMemberships () {
        return clubBoardMemberships;
    }

    public void setClubBoardMemberships (
            List<ClubBoardMemberEntity> clubBoardMemberships ) {
        this.clubBoardMemberships = clubBoardMemberships;
    }

    public UniversityEntity getUniversity () {
        return university;
    }

    public void setUniversity ( UniversityEntity university ) {
        this.university = university;
    }

    public List<EventParticipantEntity> getEventParticipants () {
        return eventParticipants;
    }

    public void setEventParticipants (
            List<EventParticipantEntity> eventParticipants ) {
        this.eventParticipants = eventParticipants;
    }

    public List<ClubFeedbackEntity> getClubFeedbacks () {
        return clubFeedbacks;
    }

    public void setClubFeedbacks (
            List<ClubFeedbackEntity> clubFeedbacks ) {
        this.clubFeedbacks = clubFeedbacks;
    }

    public List<SurveyParticipantEntity> getSurveyParticipants () {
        return surveyParticipants;
    }

    public void setSurveyParticipants (
            List<SurveyParticipantEntity> surveyParticipants ) {
        this.surveyParticipants = surveyParticipants;
    }

    public List<EventQuestionEntity> getEventQuestions () {
        return eventQuestions;
    }

    public void setEventQuestions (
            List<EventQuestionEntity> eventQuestions ) {
        this.eventQuestions = eventQuestions;
    }

    public List<EnrollRequestEntity> getEnrollRequests () {
        return enrollRequests;
    }

    public void setEnrollRequests (
            List<EnrollRequestEntity> enrollRequests ) {
        this.enrollRequests = enrollRequests;
    }

    public boolean isGeTaken () {
        return geTaken;
    }

    public void setGeTaken ( boolean geTaken ) {
        this.geTaken = geTaken;
    }
}
