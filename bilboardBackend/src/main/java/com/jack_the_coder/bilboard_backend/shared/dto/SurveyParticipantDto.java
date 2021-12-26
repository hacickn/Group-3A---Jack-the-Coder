package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.SurveyEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the survey participants
 * @implNote DONE
 * @since 20.12.2021
 */
public class SurveyParticipantDto implements Serializable {

    private static final long serialVersionUID = -7004077186911053323L;

    private long id;
    private Boolean isVoted;
    private UserEntity user;
    private SurveyEntity survey;

    /**
     * Get id method
     * @return the id
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id the id to set
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Get isVoted method
     * @return the isVoted
     */
    public Boolean getVoted () {
        return isVoted;
    }

    /**
     * Set isVoted method
     * @param isVoted the isVoted to set
     */
    public void setVoted ( Boolean voted ) {
        isVoted = voted;
    }

    /**
     * Get user method
     * @return UserEntity
     */
    public UserEntity getUser () {
        return user;
    }

    /**
     * Set user method
     * @param user the user to set
     */
    public void setUser ( UserEntity user ) {
        this.user = user;
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
     * @param survey the survey to set
     */
    public void setSurvey ( SurveyEntity survey ) {
        this.survey = survey;
    }
}
