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
 * @implNote NOT Completed
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
    private Boolean isForActiveMembers;
    private List<SurveyQuestionEntity> questions;
    private ClubEntity club;
    private List<SurveyParticipantEntity> surveyParticipants;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public String getPhoto () {
        return photo;
    }

    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    public Date getStartDate () {
        return startDate;
    }

    public void setStartDate ( Date startDate ) {
        this.startDate = startDate;
    }

    public Date getEndDate () {
        return endDate;
    }

    public void setEndDate ( Date endDate ) {
        this.endDate = endDate;
    }

    public SurveyEntity.SurveyStatus getStatus () {
        return status;
    }

    public void setStatus ( SurveyEntity.SurveyStatus status ) {
        this.status = status;
    }

    public Boolean getForActiveMembers () {
        return isForActiveMembers;
    }

    public void setForActiveMembers ( Boolean forActiveMembers ) {
        isForActiveMembers = forActiveMembers;
    }

    public List<SurveyQuestionEntity> getQuestions () {
        return questions;
    }

    public void setQuestions ( List<SurveyQuestionEntity> questions ) {
        this.questions = questions;
    }

    public ClubEntity getClub () {
        return club;
    }

    public void setClub ( ClubEntity club ) {
        this.club = club;
    }

    public List<SurveyParticipantEntity> getSurveyParticipants () {
        return surveyParticipants;
    }

    public void setSurveyParticipants (
            List<SurveyParticipantEntity> surveyParticipants ) {
        this.surveyParticipants = surveyParticipants;
    }
}
