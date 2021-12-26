package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.SurveyQuestionEntity;

import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the survey choices
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class SurveyChoiceDto implements Serializable {

    private static final long serialVersionUID = -7007177156911053223L;

    private long id;
    private String content;
    private int voteCount;
    private SurveyQuestionEntity question;

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
     * Get content method
     * @return String
     */
    public String getContent () {
        return content;
    }

    /**
     * Set content method
     * @param content is a String parameter
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
     * @param voteCount is a int parameter
     */
    public void setVoteCount ( int voteCount ) {
        this.voteCount = voteCount;
    }

    /**
     * Get question method
     * @return SurveyQuestionEntity
     */
    public SurveyQuestionEntity getQuestion () {
        return question;
    }

    /**
     * Set question method
     * @param question is a SurveyQuestionEntity parameter
     */
    public void setQuestion ( SurveyQuestionEntity question ) {
        this.question = question;
    }
}
