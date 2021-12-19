package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.SurveyEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the survey participants
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class SurveyParticipantDto implements Serializable {

    private static final long serialVersionUID = -7004077186911053323L;

    private long id;
    private Boolean isVoted;
    private UserEntity user;
    private SurveyEntity survey;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public Boolean getVoted () {
        return isVoted;
    }

    public void setVoted ( Boolean voted ) {
        isVoted = voted;
    }

    public UserEntity getUser () {
        return user;
    }

    public void setUser ( UserEntity user ) {
        this.user = user;
    }

    public SurveyEntity getSurvey () {
        return survey;
    }

    public void setSurvey ( SurveyEntity survey ) {
        this.survey = survey;
    }
}
