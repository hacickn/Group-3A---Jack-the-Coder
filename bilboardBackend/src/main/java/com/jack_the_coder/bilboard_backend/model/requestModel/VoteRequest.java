package com.jack_the_coder.bilboard_backend.model.requestModel;

import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to vote a survey
 * @implNote DONE
 * @since 05.12.2021
 */
public class VoteRequest {
    private long user;
    private long survey;
    private List<Long> choices;

    public long getUser () {
        return user;
    }

    public void setUser ( long user ) {
        this.user = user;
    }

    public long getSurvey () {
        return survey;
    }

    public void setSurvey ( long survey ) {
        this.survey = survey;
    }

    public List<Long> getChoices () {
        return choices;
    }

    public void setChoices ( List<Long> choices ) {
        this.choices = choices;
    }
}
