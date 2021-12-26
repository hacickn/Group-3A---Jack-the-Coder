package com.jack_the_coder.bilboard_backend.model.responseModel;

public class SurveyChoiceResponse {
    private long id;
    private String content;
    private int voteCount;

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
     * Get voteCount method
     * @return int
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
