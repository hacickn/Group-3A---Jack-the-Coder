package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;

import java.util.Date;

public class ClubFeedbackResponse {
    private long id;
    private String content;
    private boolean status;
    private Date date;
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
     * Get content method
     * @return String
     */
    public String getContent () {
        return content;
    }

    /**
     * Set content method
     * @param content is String
     */
    public void setContent ( String content ) {
        this.content = content;
    }

    /**
     * Get status method
     * @return boolean
     */
    public boolean isStatus () {
        return status;
    }

    /**
     * Set status method
     * @param status is boolean
     */
    public void setStatus ( boolean status ) {
        this.status = status;
    }

    /**
     * Get date method
     * @return Date
     */
    public Date getDate () {
        return date;
    }

    /**
     * Set date method
     * @param date is Date
     */
    public void setDate ( Date date ) {
        this.date = date;
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
     * @param club is BasicClubResponse instance
     */
    public void setClub ( BasicClubResponse club ) {
        this.club = club;
    }
}
