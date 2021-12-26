package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class SurveyParticipantResponse {
    private long id;
    private Boolean isVoted;
    private BasicUserResponse user;
    private SurveyResponse survey;

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
     * Get isVoted method
     * @return Boolean
     */
    public Boolean getVoted () {
        return isVoted;
    }

    /**
     * Set isVoted method
     * @param isVoted is Boolean
     */
    public void setVoted ( Boolean voted ) {
        isVoted = voted;
    }

    /**
     * Get user method
     * @return BasicUserResponse
     */
    public BasicUserResponse getUser () {
        return user;
    }

    /**
     * Set user method
     * @param user is BasicUserResponse
     */
    public void setUser ( BasicUserResponse user ) {
        this.user = user;
    }

    /**
     * Get survey method
     * @return SurveyResponse
     */
    public SurveyResponse getSurvey () {
        return survey;
    }

    /**
     * Set survey method
     * @param survey is SurveyResponse
     */
    public void setSurvey ( SurveyResponse survey ) {
        this.survey = survey;
    }
}
