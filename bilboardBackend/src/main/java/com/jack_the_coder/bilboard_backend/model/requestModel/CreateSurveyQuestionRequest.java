package com.jack_the_coder.bilboard_backend.model.requestModel;

import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to create a survey question
 * @implNote DONE
 * @since 05.12.2021
 */
public class CreateSurveyQuestionRequest {

    private String question;
    private List<CreateSurveyChoiceRequest> choices;

    /**
     * get question method
     * @return question is String
     */
    public String getQuestion () {
        return question;
    }

    public void setQuestion ( String question ) {
        this.question = question;
    }

    /**
     * get choices method
     * @return choices is List<CreateSurveyChoiceRequest>
     */
    public List<CreateSurveyChoiceRequest> getChoices () {
        return choices;
    }

    public void setChoices (
            List<CreateSurveyChoiceRequest> choices ) {
        this.choices = choices;
    }
}
