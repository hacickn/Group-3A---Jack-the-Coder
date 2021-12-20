package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;

public class SurveyParticipantResponse {
    private long id;
    private Boolean isVoted;
    private BasicUserResponse user;
    private SurveyResponse survey;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public Boolean getVoted () {
        return isVoted;
    }

    public void setVoted ( Boolean voted ) {
        isVoted = voted;
    }

    public BasicUserResponse getUser () {
        return user;
    }

    public void setUser ( BasicUserResponse user ) {
        this.user = user;
    }

    public SurveyResponse getSurvey () {
        return survey;
    }

    public void setSurvey ( SurveyResponse survey ) {
        this.survey = survey;
    }
}
