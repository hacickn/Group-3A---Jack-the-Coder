package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.EventEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the event questions
 * @implNote DONE
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
     * Get question method
     * @return String
     */
    public String getQuestion () {
        return question;
    }

    /**
     * Set question method
     * @param question is a String parameter
     */
    public void setQuestion ( String question ) {
        this.question = question;
    }

    /**
     * Get answer method
     * @return String
     */
    public String getAnswer () {
        return answer;
    }

    /**
     * Set answer method
     * @param answer is a String parameter
     */
    public void setAnswer ( String answer ) {
        this.answer = answer;
    }

    /**
     * Get date method
     * @return Date
     */
    public Date getDate () {
        return date;
    }

    /**
     * Set date method
     * @param date is a Date parameter
     */
    public void setDate ( Date date ) {
        this.date = date;
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
     * @param user is a UserEntity parameter
     */
    public void setUser ( UserEntity user ) {
        this.user = user;
    }

    /**
     * Get event method
     * @return EventEntity
     */
    public EventEntity getEvent () {
        return event;
    }

    /**
     * Set event method
     * @param event is a EventEntity parameter
     */
    public void setEvent ( EventEntity event ) {
        this.event = event;
    }
}
