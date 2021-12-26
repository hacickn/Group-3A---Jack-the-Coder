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

    /**
     * Get id method
     * @return long
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id is a long parameter
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
     * @param question is a String parameter
     */
    public void setQuestion ( String question ) {
        this.question = question;
    }

    /**
     * Get survey method
     * @return SurveyEntity
     */
    public SurveyEntity getSurvey () {
        return survey;
    }

    /**
     * Set survey method
     * @param survey is a SurveyEntity parameter
     */
    public void setSurvey ( SurveyEntity survey ) {
        this.survey = survey;
    }

    /**
     * Get choices method
     * @return List<SurveyChoiceEntity>
     */
    public List<SurveyChoiceEntity> getChoices () {
        return choices;
    }
    
    /**
     * Set choices method
     * @param choices is a List<SurveyChoiceEntity> parameter
     */
    public void setChoices ( List<SurveyChoiceEntity> choices ) {
        this.choices = choices;
    }
}
