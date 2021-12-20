package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.io.entity.SurveyEntity;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;

import java.util.Date;
import java.util.List;

public class SurveyResponse {

    private long id;
    private String title;
    private String photo;
    private Date startDate;
    private Date endDate;
    private SurveyEntity.SurveyStatus status;
    private Boolean isForActiveMembers;
    private List<SurveyQuestionResponse> questions;
    private BasicClubResponse club;

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

    public List<SurveyQuestionResponse> getQuestions () {
        return questions;
    }

    public void setQuestions (
            List<SurveyQuestionResponse> questions ) {
        this.questions = questions;
    }

    public BasicClubResponse getClub () {
        return club;
    }

    public void setClub ( BasicClubResponse club ) {
        this.club = club;
    }
}
