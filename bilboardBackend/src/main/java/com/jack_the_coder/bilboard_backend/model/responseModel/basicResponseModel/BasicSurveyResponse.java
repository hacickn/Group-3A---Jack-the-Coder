package com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel;

import com.jack_the_coder.bilboard_backend.io.entity.SurveyEntity;

import java.util.Date;

public class BasicSurveyResponse {
    private long id;
    private String title;
    private String photo;
    private Date startDate;
    private Date endDate;
    private SurveyEntity.SurveyStatus status;
    private Boolean forActiveMembers;

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
        return forActiveMembers;
    }

    public void setForActiveMembers ( Boolean forActiveMembers ) {
        this.forActiveMembers = forActiveMembers;
    }
}
