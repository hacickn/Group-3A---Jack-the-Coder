package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.io.entity.SurveyEntity;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;

import java.util.Date;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class SurveyResponse {

    private long id;
    private String title;
    private String photo;
    private Date startDate;
    private Date endDate;
    private SurveyEntity.SurveyStatus status;
    private Boolean forActiveMembers;
    private List<SurveyQuestionResponse> questions;
    private BasicClubResponse club;

    /**
     * Get id method
     * @return long
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id is an long parameter
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
     * @param title is String
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
     * @param photo is String
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
     * @param startDate is Date
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
     * @param endDate is Date
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
     * @param status is SurveyEntity.SurveyStatus
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
     * @param forActiveMembers is Boolean
     */
    public void setForActiveMembers ( Boolean forActiveMembers ) {
        this.forActiveMembers = forActiveMembers;
    }

    /**
     * Get questions method
     * @return List<SurveyQuestionResponse>
     */
    public List<SurveyQuestionResponse> getQuestions () {
        return questions;
    }

    /**
     * Set questions method
     * @param questions is List<SurveyQuestionResponse>
     */
    public void setQuestions (
            List<SurveyQuestionResponse> questions ) {
        this.questions = questions;
    }

    /**
     * Get club method
     * @return BasicClubResponse
     */
    public BasicClubResponse getClub () {
        return club;
    }

    /**
     * Set club method
     * @param club is BasicClubResponse
     */
    public void setClub ( BasicClubResponse club ) {
        this.club = club;
    }
}
