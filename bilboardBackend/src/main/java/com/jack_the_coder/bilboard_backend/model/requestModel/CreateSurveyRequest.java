package com.jack_the_coder.bilboard_backend.model.requestModel;

import com.jack_the_coder.bilboard_backend.io.entity.SurveyEntity;

import java.util.Date;
import java.util.List;

public class CreateSurveyRequest {

    private String title;
    private Date startDate;
    private Date endDate;
    private SurveyEntity.SurveyStatus status;
    private Boolean isForActiveMembers;
    private List<CreateSurveyQuestionRequest> questions;
    private long club;
    private int point;

    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
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

    public long getClub () {
        return club;
    }

    public void setClub ( long club ) {
        this.club = club;
    }

    public List<CreateSurveyQuestionRequest> getQuestions () {
        return questions;
    }

    public void setQuestions (
            List<CreateSurveyQuestionRequest> questions ) {
        this.questions = questions;
    }

    public int getPoint () {
        return point;
    }

    public void setPoint ( int point ) {
        this.point = point;
    }
}
