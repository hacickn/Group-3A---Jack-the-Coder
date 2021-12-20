package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;

import java.util.Date;

public class EventQuestionResponse {

    private long id;
    private String question;
    private String answer;
    private Date date;
    private BasicUserResponse userResponse;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getQuestion () {
        return question;
    }

    public void setQuestion ( String question ) {
        this.question = question;
    }

    public String getAnswer () {
        return answer;
    }

    public void setAnswer ( String answer ) {
        this.answer = answer;
    }

    public Date getDate () {
        return date;
    }

    public void setDate ( Date date ) {
        this.date = date;
    }

    public BasicUserResponse getUserResponse () {
        return userResponse;
    }

    public void setUserResponse (
            BasicUserResponse userResponse ) {
        this.userResponse = userResponse;
    }
}
