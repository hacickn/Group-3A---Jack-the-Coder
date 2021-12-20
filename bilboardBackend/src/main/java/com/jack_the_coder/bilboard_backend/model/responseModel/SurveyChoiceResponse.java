package com.jack_the_coder.bilboard_backend.model.responseModel;

public class SurveyChoiceResponse {
    private long id;
    private String content;
    private int voteCount;

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

    public int getVoteCount () {
        return voteCount;
    }

    public void setVoteCount ( int voteCount ) {
        this.voteCount = voteCount;
    }
}
