package com.jack_the_coder.bilboard_backend.model.requestModel;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.util.Date;

public class CreateClubFeedbackRequest {
    private String content;
    private Date date;
    private long club;
    private long user;

    public String getContent () {
        return content;
    }

    public void setContent ( String content ) {
        this.content = content;
    }

    public Date getDate () {
        return date;
    }

    public void setDate ( Date date ) {
        this.date = date;
    }

    public long getClub () {
        return club;
    }

    public void setClub ( long club ) {
        this.club = club;
    }

    public long getUser () {
        return user;
    }

    public void setUser ( long user ) {
        this.user = user;
    }
}
