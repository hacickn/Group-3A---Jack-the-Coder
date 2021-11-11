package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Hacı Çakın
 * @apiNote This class is base structure of the survey_choices table in database
 * @implNote DONE
 * @since 09.11.2021
 */
@Entity( name = "survey_choices" )
public class SurveyChoiceEntity implements Serializable {

    private static final long serialVersionUID = -2340163411490305735L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "content", length = 100, nullable = false )
    private String content;

    @Column( name = "vote_count" )
    private int voteCount;

    @ManyToOne( targetEntity = SurveyEntity.class )
    @JoinColumn( name = "survey" )
    private SurveyEntity survey;

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
     * Get content method
     * @return String
     */
    public String getContent () {
        return content;
    }

    /**
     * Set content method
     * @param content is String
     */
    public void setContent ( String content ) {
        this.content = content;
    }

    /**
     * get vote count method
     * @return int
     */
    public int getVoteCount () {
        return voteCount;
    }

    /**
     * set vote count method
     * @param voteCount is int
     */
    public void setVoteCount ( int voteCount ) {
        this.voteCount = voteCount;
    }

    /**
     * get survey method
     * @return SurveyEntity object
     */
    public SurveyEntity getSurvey () {
        return survey;
    }

    /**
     * set survey method
     * @param survey is SurveyEntity instance
     */
    public void setSurvey ( SurveyEntity survey ) {
        this.survey = survey;
    }
}
