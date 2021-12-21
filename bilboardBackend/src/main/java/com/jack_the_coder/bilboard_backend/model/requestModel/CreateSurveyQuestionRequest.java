package com.jack_the_coder.bilboard_backend.model.requestModel;

import java.util.List;

public class CreateSurveyQuestionRequest {

    private String question;
    private List<CreateSurveyChoiceRequest> choices;

    public String getQuestion () {
        return question;
    }

    public void setQuestion ( String question ) {
        this.question = question;
    }

    public List<CreateSurveyChoiceRequest> getChoices () {
        return choices;
    }

    public void setChoices (
            List<CreateSurveyChoiceRequest> choices ) {
        this.choices = choices;
    }
}
