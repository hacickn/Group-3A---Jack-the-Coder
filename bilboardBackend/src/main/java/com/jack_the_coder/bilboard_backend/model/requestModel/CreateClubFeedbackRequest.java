package com.jack_the_coder.bilboard_backend.model.requestModel;

public class CreateClubFeedbackRequest {
    private String content;
    private long club;
    private long user;

    public String getContent () {
        return content;
    }

    public void setContent ( String content ) {
        this.content = content;
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
