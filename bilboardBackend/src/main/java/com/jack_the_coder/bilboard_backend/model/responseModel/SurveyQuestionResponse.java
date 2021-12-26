package com.jack_the_coder.bilboard_backend.model.responseModel;

import java.util.List;

public class SurveyQuestionResponse {
    private long id;
    private String question;
    private List<SurveyChoiceResponse> choices;

    /**
     * Get id method
     * @return long
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id is an long parameter
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Get question method
     * @return String
     */
    public String getQuestion () {
        return question;
    }

    /**
     * Set question method
     * @param question is String
     */
    public void setQuestion ( String question ) {
        this.question = question;
    }

    /**
     * Get choices method
     * @return List<SurveyChoiceResponse>
     */
    public List<SurveyChoiceResponse> getChoices () {
        return choices;
    }

    /**
     * Set choices method
     * @param choices is List<SurveyChoiceResponse>
     */
    public void setChoices (
            List<SurveyChoiceResponse> choices ) {
        this.choices = choices;
    }
}
