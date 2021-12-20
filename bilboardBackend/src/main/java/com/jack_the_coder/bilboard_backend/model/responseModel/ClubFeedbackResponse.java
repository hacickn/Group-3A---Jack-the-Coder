package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;

import java.util.Date;

public class ClubFeedbackResponse {
    private long id;
    private String content;
    private Date date;
    private BasicClubResponse club;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

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

    public BasicClubResponse getClub () {
        return club;
    }

    public void setClub ( BasicClubResponse club ) {
        this.club = club;
    }
}
