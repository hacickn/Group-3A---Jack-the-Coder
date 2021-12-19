package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.EventEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the event questions
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class EventQuestionDto implements Serializable {

    private static final long serialVersionUID = -4701452319296783715L;

    private long id;
    private String question;
    private String answer;
    private Date date;
    private UserEntity user;
    private EventEntity event;

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

    public UserEntity getUser () {
        return user;
    }

    public void setUser ( UserEntity user ) {
        this.user = user;
    }

    public EventEntity getEvent () {
        return event;
    }

    public void setEvent ( EventEntity event ) {
        this.event = event;
    }
}
