package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.SurveyChoiceEntity;
import com.jack_the_coder.bilboard_backend.io.entity.SurveyEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the survey questions
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class SurveyQuestionDto implements Serializable {

    private static final long serialVersionUID = -7004377126711053223L;

    private long id;
    private String question;
    private SurveyEntity survey;
    private List<SurveyChoiceEntity> choices;

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

    public SurveyEntity getSurvey () {
        return survey;
    }

    public void setSurvey ( SurveyEntity survey ) {
        this.survey = survey;
    }

    public List<SurveyChoiceEntity> getChoices () {
        return choices;
    }

    public void setChoices ( List<SurveyChoiceEntity> choices ) {
        this.choices = choices;
    }
}
