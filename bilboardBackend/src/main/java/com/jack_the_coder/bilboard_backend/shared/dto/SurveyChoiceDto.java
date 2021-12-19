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

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getContent () {
        return content;
    }

    public void setContent ( String content ) {
        this.content = content;
    }

    public int getVoteCount () {
        return voteCount;
    }

    public void setVoteCount ( int voteCount ) {
        this.voteCount = voteCount;
    }

    public SurveyQuestionEntity getQuestion () {
        return question;
    }

    public void setQuestion ( SurveyQuestionEntity question ) {
        this.question = question;
    }
}
