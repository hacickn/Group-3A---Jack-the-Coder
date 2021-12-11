package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Hacı Çakın, Aslı Dinç
 * @apiNote This class is base structure of the surveys table in database
 * @implNote DONE
 * @since 11.12.2021
 */
@Entity( name = "survey_questions" )
public class SurveyQuestionEntity implements Serializable {

    private static final long serialVersionUID = 3994555133317443003L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "question", length = 100, nullable = false )
    private String question;

    @ManyToOne( targetEntity = SurveyEntity.class )
    @JoinColumn( name = "survey" )
    private SurveyEntity survey;

    @OneToMany( targetEntity = SurveyChoiceEntity.class, mappedBy = "question" )
    private List<SurveyChoiceEntity> choices;

    // todo
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
