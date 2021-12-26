package com.jack_the_coder.bilboard_backend.model.requestModel;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to create a survey choice
 * @implNote DONE
 * @since 05.12.2021
 */
public class CreateSurveyChoiceRequest {
    private String content;
    private int voteCount;

    /**
     * get content method
     * @return content is String
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
     * get voteCount method
     * @return voteCount is int
     */
    public int getVoteCount () {
        return voteCount;
    }

    /**
     * Set voteCount method
     * @param voteCount is int
     */
    public void setVoteCount ( int voteCount ) {
        this.voteCount = voteCount;
    }
}
