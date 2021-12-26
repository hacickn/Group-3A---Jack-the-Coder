package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın and Aslı Dinç
 * @apiNote This class is data transfer object of the users
 * @implNote DONE
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
    private String photo;
    private ClubEntity presidentOf;
    private ClubEntity advisorOf;
    private List<ClubMemberEntity> clubMemberShips;
    private List<ClubBoardMemberEntity> clubBoardMemberships;
    private UniversityEntity university;
    private PasswordResetTokenEntity resetTokenEntity;
    private List<EventParticipantEntity> eventParticipants;
    private List<ClubFeedbackEntity> clubFeedbacks;
    private List<SurveyParticipantEntity> surveyParticipants;
    private List<EventQuestionEntity> eventQuestions;
    private List<EnrollRequestEntity> enrollRequests;

    /**
     * Get id method
     * @return long
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id is a long parameter
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
     * @param name is a String parameter
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
     * @param surname is a String parameter
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
     * @param type is a UserEntity.UserTypes parameter
     */
    public void setType ( UserEntity.UserTypes type ) {
        this.type = type;
    }

    /**
     * Get password method
     * @return String
     */
    public String getPassword () {
        return password;
    }

    /**
     * Set password method
     * @param password is a String parameter
     */
    public void setPassword ( String password ) {
        this.password = password;
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
     * @param bilkentId is a String parameter
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
     * @param email is a String parameter
     */
    public void setEmail ( String email ) {
        this.email = email;
    }

    /**
     * Get emailConfirmation method
     * @return boolean
     */
    public boolean isEmailConfirmation () {
        return emailConfirmation;
    }

    /**
     * Set emailConfirmation method
     * @param emailConfirmation is a boolean parameter
     */
    public void setEmailConfirmation ( boolean emailConfirmation ) {
        this.emailConfirmation = emailConfirmation;
    }

    /**
     * Get emailConfirmationToken method
     * @return String
     */
    public String getEmailConfirmationToken () {
        return emailConfirmationToken;
    }

    /**
     * Set emailConfirmationToken method
     * @param emailConfirmationToken is a String parameter
     */
    public void setEmailConfirmationToken ( String emailConfirmationToken ) {
        this.emailConfirmationToken = emailConfirmationToken;
    }

    /**
     * Get jwtExpirationTime method
     * @return Date
     */
    public Date getJwtExpirationTime () {
        return jwtExpirationTime;
    }

    /**
     * Set jwtExpirationTime method
     * @param jwtExpirationTime is a Date parameter
     */
    public void setJwtExpirationTime ( Date jwtExpirationTime ) {
        this.jwtExpirationTime = jwtExpirationTime;
    }

    /**
     * Get president of method
     * @return ClubEntity
     */
    public ClubEntity getPresidentOf () {
        return presidentOf;
    }

    /**
     * Set president of method
     * @param presidentOf is a ClubEntity parameter
     */
    public void setPresidentOf ( ClubEntity presidentOf ) {
        this.presidentOf = presidentOf;
    }

    /**
     * Get advisor of method
     * @return ClubEntity
     */
    public ClubEntity getAdvisorOf () {
        return advisorOf;
    }

    /**
     * Set advisor of method
     * @param advisorOf is a ClubEntity parameter
     */
    public void setAdvisorOf ( ClubEntity advisorOf ) {
        this.advisorOf = advisorOf;
    }

    /**
     * Get club member ships method
     * @return List<ClubMemberEntity>
     */
    public List<ClubMemberEntity> getClubMemberShips () {
        return clubMemberShips;
    }

    /**
     * Set club member ships method
     * @param clubMemberShips is a List<ClubMemberEntity> parameter
     */
    public void setClubMemberShips (
            List<ClubMemberEntity> clubMemberShips ) {
        this.clubMemberShips = clubMemberShips;
    }

    /**
     * Get club board memberships method
     * @return List<ClubBoardMemberEntity>
     */
    public List<ClubBoardMemberEntity> getClubBoardMemberships () {
        return clubBoardMemberships;
    }

    /**
     * Set club board memberships method
     * @param clubBoardMemberships is a List<ClubBoardMemberEntity> parameter
     */
    public void setClubBoardMemberships (
            List<ClubBoardMemberEntity> clubBoardMemberships ) {
        this.clubBoardMemberships = clubBoardMemberships;
    }

    /**
     * Get university method
     * @return UniversityEntity
     */
    public UniversityEntity getUniversity () {
        return university;
    }

    /**
     * Set university method
     * @param university is a UniversityEntity parameter
     */
    public void setUniversity ( UniversityEntity university ) {
        this.university = university;
    }

    /**
     * Get eventParticipants method
     * @return ist<EventParticipantEntity>
     */
    public List<EventParticipantEntity> getEventParticipants () {
        return eventParticipants;
    }

    /**
     * Set event participants method
     * @param eventParticipants is a List<EventParticipantEntity> parameter
     */
    public void setEventParticipants (
            List<EventParticipantEntity> eventParticipants ) {
        this.eventParticipants = eventParticipants;
    }

    /**
     * Get clubFeedbacks method
     * @return List<ClubFeedbackEntity>
     */
    public List<ClubFeedbackEntity> getClubFeedbacks () {
        return clubFeedbacks;
    }

    /**
     * Set club feedbacks method
     * @param clubFeedbacks is a List<ClubFeedbackEntity> parameter
     */
    public void setClubFeedbacks (
            List<ClubFeedbackEntity> clubFeedbacks ) {
        this.clubFeedbacks = clubFeedbacks;
    }

    /**
     * Get surveyParticipants method
     * @return List<SurveyParticipantEntity>
     */
    public List<SurveyParticipantEntity> getSurveyParticipants () {
        return surveyParticipants;
    }

    /**
     * Set survey participants method
     * @param surveyParticipants is a List<SurveyParticipantEntity> parameter
     */
    public void setSurveyParticipants (
            List<SurveyParticipantEntity> surveyParticipants ) {
        this.surveyParticipants = surveyParticipants;
    }

    /**
     * Get event questions method
     * @return List<EventQuestionEntity>
     */
    public List<EventQuestionEntity> getEventQuestions () {
        return eventQuestions;
    }

    /**
     * Set event questions method
     * @param eventQuestions is a List<EventQuestionEntity> parameter
     */
    public void setEventQuestions (
            List<EventQuestionEntity> eventQuestions ) {
        this.eventQuestions = eventQuestions;
    }

    /**
     * Get enrollRequests method
     * @return List<EnrollRequestEntity>
     */
    public List<EnrollRequestEntity> getEnrollRequests () {
        return enrollRequests;
    }

    /**
     * Set enroll requests method
     * @param enrollRequests is a List<EnrollRequestEntity> parameter
     */
    public void setEnrollRequests (
            List<EnrollRequestEntity> enrollRequests ) {
        this.enrollRequests = enrollRequests;
    }

    /**
     * Get geTaken method
     * @return boolean
     */
    public boolean isGeTaken () {
        return geTaken;
    }

    /**
     * Set ge taken method
     * @param geTaken is a boolean parameter
     */
    public void setGeTaken ( boolean geTaken ) {
        this.geTaken = geTaken;
    }

    /**
     * Get resetTokenEntity method
     * @return PasswordResetTokenEntity
     */
    public PasswordResetTokenEntity getResetTokenEntity () {
        return resetTokenEntity;
    }

    /**
     * Set reset token entity method
     * @param resetTokenEntity is a PasswordResetTokenEntity parameter
     */
    public void setResetTokenEntity ( PasswordResetTokenEntity resetTokenEntity ) {
        this.resetTokenEntity = resetTokenEntity;
    }

    /**
     * getPhoto method
     * @return String
     */
    public String getPhoto () {
        return photo;
    }

    /**
     * Set photo method
     * @param photo is a String parameter
     */
    public void setPhoto ( String photo ) {
        this.photo = photo;
    }
}
