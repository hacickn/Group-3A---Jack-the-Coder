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

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public BasicUserResponse getUser () {
        return user;
    }

    public void setUser ( BasicUserResponse user ) {
        this.user = user;
    }

    public Date getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt ( Date createdAt ) {
        this.createdAt = createdAt;
    }

    public EnrollRequestEntity.RequestStatus getStatus () {
        return status;
    }

    public void setStatus ( EnrollRequestEntity.RequestStatus status ) {
        this.status = status;
    }

    public BasicClubResponse getClub () {
        return club;
    }

    public void setClub ( BasicClubResponse club ) {
        this.club = club;
    }
}
