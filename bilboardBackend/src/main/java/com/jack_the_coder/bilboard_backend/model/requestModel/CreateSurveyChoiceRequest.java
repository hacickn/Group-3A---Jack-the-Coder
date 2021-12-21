package com.jack_the_coder.bilboard_backend.model.requestModel;

public class CreateSurveyChoiceRequest {
    private String content;
    private int voteCount;

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
