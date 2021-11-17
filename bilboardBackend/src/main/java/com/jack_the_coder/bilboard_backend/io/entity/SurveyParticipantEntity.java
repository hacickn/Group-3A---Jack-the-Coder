package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the survey participants in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 11.11.2021
 */
@Entity( name = "survey_participants" )
public class SurveyParticipantEntity implements Serializable {

    private static final long serialVersionUID = -3993241986569215136L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "is_voted" )
    private Boolean isVoted;

    @ManyToOne( targetEntity = UserEntity.class )
    @JoinColumn( name = "user" )
    private UserEntity user;

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
     * Get voted method
     * @return Boolean
     */
    public Boolean getVoted () {
        return isVoted;
    }

    /**
     * Set voted method
     * @param voted is a Boolean parameter
     */
    public void setVoted ( Boolean voted ) {
        isVoted = voted;
    }

    /**
     * Get user method
     * @return UserEntity object
     */
    public UserEntity getUser () {
        return user;
    }

    /**
     * Set user method
     * @param user is UserEntity
     */
    public void setUser ( UserEntity user ) {
        this.user = user;
    }

    /**
     * Get survey method
     * @return SurveyEntity object
     */
    public SurveyEntity getSurvey () {
        return survey;
    }

    /**
     * Set survey method
     * @param survey is SurveyEntity
     */
    public void setSurvey ( SurveyEntity survey ) {
        this.survey = survey;
    }
}
