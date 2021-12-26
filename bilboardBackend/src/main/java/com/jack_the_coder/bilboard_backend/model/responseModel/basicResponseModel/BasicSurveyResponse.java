package com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel;

import com.jack_the_coder.bilboard_backend.io.entity.SurveyEntity;

import java.util.Date;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class BasicSurveyResponse {
    private long id;
    private String title;
    private String photo;
    private Date startDate;
    private Date endDate;
    private SurveyEntity.SurveyStatus status;
    private Boolean forActiveMembers;

    /**
     * get id method
     * @return id is a long
     */
    public long getId () {
        return id;
    }

    /**
     * set id method
     * @param id is a long parameter
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * get title method
     * @return title is String
     */
    public String getTitle () {
        return title;
    }

    /**
     * set title method
     * @param title is String
     */
    public void setTitle ( String title ) {
        this.title = title;
    }

    /**
     * get photo method
     * @return photo is String
     */
    public String getPhoto () {
        return photo;
    }

    /**
     * set photo method
     * @param photo is String
     */
    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    /**
     * get start date method
     * @return startDate is Date
     */
    public Date getStartDate () {
        return startDate;
    }

    /**
     * set start date method
     * @param startDate is Date
     */
    public void setStartDate ( Date startDate ) {
        this.startDate = startDate;
    }

    /**
     * get end date method
     * @return endDate is Date
     */
    public Date getEndDate () {
        return endDate;
    }

    /**
     * set end date method
     * @param endDate is Date
     */
    public void setEndDate ( Date endDate ) {
        this.endDate = endDate;
    }

    /**
     * get status method
     * @return status is SurveyStatus
     */
    public SurveyEntity.SurveyStatus getStatus () {
        return status;
    }

    /**
     * set status method
     * @param status is SurveyStatus
     */
    public void setStatus ( SurveyEntity.SurveyStatus status ) {
        this.status = status;
    }

    /**
     * get for active members method
     * @return isForActiveMembers is Boolean
     */
    public Boolean getForActiveMembers () {
        return forActiveMembers;
    }

    /**
     * set for active members method
     * @param forActiveMembers is Boolean
     */
    public void setForActiveMembers ( Boolean forActiveMembers ) {
        this.forActiveMembers = forActiveMembers;
    }
}
