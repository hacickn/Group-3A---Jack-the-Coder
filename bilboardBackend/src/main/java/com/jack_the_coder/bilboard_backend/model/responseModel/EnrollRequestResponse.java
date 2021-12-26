package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.io.entity.EnrollRequestEntity;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;

import java.util.Date;

public class EnrollRequestResponse {
    private long id;
    private BasicUserResponse user;
    private Date createdAt;
    private EnrollRequestEntity.RequestStatus status;
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
     * Get user method
     * @return BasicUserResponse
     */
    public BasicUserResponse getUser () {
        return user;
    }

    /**
     * Set user method
     * @param user is BasicUserResponse
     */
    public void setUser ( BasicUserResponse user ) {
        this.user = user;
    }

    /**
     * Get createdAt method
     * @return Date
     */
    public Date getCreatedAt () {
        return createdAt;
    }

    /**
     * Set createdAt method
     * @param createdAt is Date
     */
    public void setCreatedAt ( Date createdAt ) {
        this.createdAt = createdAt;
    }

    /**
     * Get status method
     * @return EnrollRequestEntity.RequestStatus
     */
    public EnrollRequestEntity.RequestStatus getStatus () {
        return status;
    }

    /**
     * Set status method
     * @param status is EnrollRequestEntity.RequestStatus
     */
    public void setStatus ( EnrollRequestEntity.RequestStatus status ) {
        this.status = status;
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
