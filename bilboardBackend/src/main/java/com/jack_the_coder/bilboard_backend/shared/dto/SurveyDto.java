package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.SurveyEntity;
import com.jack_the_coder.bilboard_backend.io.entity.SurveyParticipantEntity;
import com.jack_the_coder.bilboard_backend.io.entity.SurveyQuestionEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the surveys
 * @implNote DONE
 * @since 20.12.2021
 */
public class SurveyDto implements Serializable {

    private static final long serialVersionUID = -7002227156911053223L;

    private long id;
    private String title;
    private String photo;
    private Date startDate;
    private Date endDate;
    private SurveyEntity.SurveyStatus status;
    private Boolean forActiveMembers;

    private List<SurveyQuestionEntity> questions;
    private ClubEntity club;
    private List<SurveyParticipantEntity> surveyParticipants;

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
     * Get title method
     * @return String
     */
    public String getTitle () {
        return title;
    }

    /**
     * Set title method
     * @param title is a String parameter
     */
    public void setTitle ( String title ) {
        this.title = title;
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
     * @param photo is a String parameter
     */
    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    /**
     * Get startDate method
     * @return Date
     */
    public Date getStartDate () {
        return startDate;
    }

    /**
     * Set startDate method
     * @param startDate is a Date parameter
     */
    public void setStartDate ( Date startDate ) {
        this.startDate = startDate;
    }

    /**
     * Get endDate method
     * @return Date
     */
    public Date getEndDate () {
        return endDate;
    }

    /**
     * Set endDate method
     * @param endDate is a Date parameter
     */
    public void setEndDate ( Date endDate ) {
        this.endDate = endDate;
    }

    /**
     * Get status method
     * @return SurveyEntity.SurveyStatus
     */
    public SurveyEntity.SurveyStatus getStatus () {
        return status;
    }

    /**
     * Set status method
     * @param status is a SurveyEntity.SurveyStatus parameter
     */
    public void setStatus ( SurveyEntity.SurveyStatus status ) {
        this.status = status;
    }

    /**
     * Get forActiveMembers method
     * @return Boolean
     */
    public Boolean getForActiveMembers () {
        return forActiveMembers;
    }

    /**
     * Set forActiveMembers method
     * @param forActiveMembers is a Boolean parameter
     */
    public void setForActiveMembers ( Boolean forActiveMembers ) {
        this.forActiveMembers = forActiveMembers;
    }

    /**
     * Get questions method
     * @return List<SurveyQuestionEntity>
     */
    public List<SurveyQuestionEntity> getQuestions () {
        return questions;
    }

    /**
     * Set questions method
     * @param questions is a List<SurveyQuestionEntity> parameter
     */
    public void setQuestions ( List<SurveyQuestionEntity> questions ) {
        this.questions = questions;
    }
    
    /**
     * Get club method
     * @return ClubEntity
     */
    public ClubEntity getClub () {
        return club;
    }

    /**
     * Set club method
     * @param club is a ClubEntity parameter
     */
    public void setClub ( ClubEntity club ) {
        this.club = club;
    }

    /**
     * Get surveyParticipants method
     * @return List<SurveyParticipantEntity>
     */
    public List<SurveyParticipantEntity> getSurveyParticipants () {
        return surveyParticipants;
    }

    /**
     * Set surveyParticipants method
     * @param surveyParticipants is a List<SurveyParticipantEntity> parameter
     */
    public void setSurveyParticipants (
            List<SurveyParticipantEntity> surveyParticipants ) {
        this.surveyParticipants = surveyParticipants;
    }
}
