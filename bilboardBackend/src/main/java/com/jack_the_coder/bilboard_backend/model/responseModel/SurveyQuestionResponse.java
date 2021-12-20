package com.jack_the_coder.bilboard_backend.model.responseModel;

import java.util.List;

public class SurveyQuestionResponse {
    private long id;
    private String question;
    private List<SurveyChoiceResponse> choices;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getQuestion () {
        return question;
    }

    public void setQuestion ( String question ) {
        this.question = question;
    }

    public List<SurveyChoiceResponse> getChoices () {
        return choices;
    }

    public void setChoices (
            List<SurveyChoiceResponse> choices ) {
        this.choices = choices;
    }
}
