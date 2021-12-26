package com.jack_the_coder.bilboard_backend.model.requestModel;

import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to vote a survey
 * @implNote DONE
 * @since 05.12.2021
 */
public class VoteRequest {
    private long user;
    private long survey;
    private List<Long> choices;

    /**
     * get user method
     * @return user is long
     */
    public long getUser () {
        return user;
    }

    /**
     * Set user method
     * @param user is long
     */
    public void setUser ( long user ) {
        this.user = user;
    }

    /**
     * get survey method
     * @return survey is long
     */
    public long getSurvey () {
        return survey;
    }

    /**
     * Set survey method
     * @param survey is long
     */
    public void setSurvey ( long survey ) {
        this.survey = survey;
    }

    /**
     * get choices method
     * @return choices is List<Long>
     */
    public List<Long> getChoices () {
        return choices;
    }

    /**
     * Set choices method
     * @param choices is List<Long>
     */
    public void setChoices ( List<Long> choices ) {
        this.choices = choices;
    }
}
