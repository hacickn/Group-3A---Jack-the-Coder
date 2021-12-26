package com.jack_the_coder.bilboard_backend.model.requestModel;

import com.jack_the_coder.bilboard_backend.io.entity.SurveyEntity;

import java.util.Date;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to create a survey
 * @implNote DONE
 * @since 05.12.2021
 */
public class CreateSurveyRequest {

    private String title;
    private Date startDate;
    private Date endDate;
    private SurveyEntity.SurveyStatus status;
    private Boolean isForActiveMembers;
    private List<CreateSurveyQuestionRequest> questions;
    private long club;
    private int point;

    /**
     * get title method
     * @return title is String
     */
    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    /**
     * get startDate method
     * @return question is String
     */
    public Date getStartDate () {
        return startDate;
    }

    public void setStartDate ( Date startDate ) {
        this.startDate = startDate;
    }

    /**
     * get question method
     * @return question is String
     */
    public Date getEndDate () {
        return endDate;
    }

    public void setEndDate ( Date endDate ) {
        this.endDate = endDate;
    }

    /**
     * get question method
     * @return question is String
     */
    public SurveyEntity.SurveyStatus getStatus () {
        return status;
    }

    public void setStatus ( SurveyEntity.SurveyStatus status ) {
        this.status = status;
    }

    /**
     * get question method
     * @return question is String
     */
    public Boolean getForActiveMembers () {
        return isForActiveMembers;
    }

    public void setForActiveMembers ( Boolean forActiveMembers ) {
        isForActiveMembers = forActiveMembers;
    }

    /**
     * get question method
     * @return question is String
     */
    public long getClub () {
        return club;
    }

    public void setClub ( long club ) {
        this.club = club;
    }

    /**
     * get question method
     * @return question is String
     */
    public List<CreateSurveyQuestionRequest> getQuestions () {
        return questions;
    }

    public void setQuestions (
            List<CreateSurveyQuestionRequest> questions ) {
        this.questions = questions;
    }

    /**
     * get question method
     * @return question is String
     */
    public int getPoint () {
        return point;
    }

    public void setPoint ( int point ) {
        this.point = point;
    }
}
