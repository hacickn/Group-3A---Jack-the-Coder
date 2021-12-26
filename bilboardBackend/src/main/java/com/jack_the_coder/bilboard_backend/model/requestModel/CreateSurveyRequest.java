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

    /**
     * Set title method
     * @param title is String
     */
    public void setTitle ( String title ) {
        this.title = title;
    }

    /**
     * get startDate method
     * @return startDate is Date
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
     * get endDate method
     * @return endDate is Date
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
     * get status method
     * @return status is SurveyStatus
     */
    public SurveyEntity.SurveyStatus getStatus () {
        return status;
    }

    /**
     * Set status method
     * @param status is SurveyStatus
     */
    public void setStatus ( SurveyEntity.SurveyStatus status ) {
        this.status = status;
    }

    /**
     * get isForActiveMembers method
     * @return isForActiveMembers is boolean
     */
    public Boolean getForActiveMembers () {
        return isForActiveMembers;
    }

    /**
     * Set forActiveMembers method
     * @param forActiveMembers is boolean
     */
    public void setForActiveMembers ( Boolean forActiveMembers ) {
        isForActiveMembers = forActiveMembers;
    }

    /**
     * get club method
     * @return club is long
     */
    public long getClub () {
        return club;
    }

    /**
     * Set club method
     * @param club is long
     */
    public void setClub ( long club ) {
        this.club = club;
    }

    /**
     * get questions method
     * @return questions is List<CreateSurveyQuestionRequest>
     */
    public List<CreateSurveyQuestionRequest> getQuestions () {
        return questions;
    }

    /**
     * Set questions method
     * @param questions is List<CreateSurveyQuestionRequest>
     */
    public void setQuestions (
            List<CreateSurveyQuestionRequest> questions ) {
        this.questions = questions;
    }

    /**
     * get point method
     * @return point is int
     */
    public int getPoint () {
        return point;
    }

    /**
     * Set point method
     * @param point is int
     */
    public void setPoint ( int point ) {
        this.point = point;
    }
}
