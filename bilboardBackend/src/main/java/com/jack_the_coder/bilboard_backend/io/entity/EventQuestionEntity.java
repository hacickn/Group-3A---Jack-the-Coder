package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the event question table in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 09.11.2021
 */
@Entity( name = "event_questions" )
public class EventQuestionEntity implements Serializable {

    private static final long serialVersionUID = -3201104561449889311L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "question", length = 300, nullable = false )
    private String question;

    @Column( name = "answer", length = 300, nullable = false )
    private String answer;

    @Column( name = "date", nullable = false )
    private Date date;

    @ManyToOne( targetEntity = UserEntity.class )
    @JoinColumn( name = "user" )
    private UserEntity user;

    @ManyToOne( targetEntity = EventEntity.class )
    @JoinColumn( name = "event" )
    private EventEntity event;

    /**
     * Get id method
     * @return long
     */
    public long getId () {
        return id;
    }

    /**
     * set id method
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
     * @param question is a String
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
     * @param answer is a String
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
     * @param date is a Date
     */
    public void setDate ( Date date ) {
        this.date = date;
    }

    /**
     * get user method
     * @return UserEntity object
     */
    public UserEntity getUser () {
        return user;
    }

    /**
     * set user method
     * @param user is userEntity instance
     */
    public void setUser ( UserEntity user ) {
        this.user = user;
    }

    /**
     * get event method
     * @return EventEntity object
     */
    public EventEntity getEvent () {
        return event;
    }

    /**
     * set event method
     * @param event is EventEntity instance
     */
    public void setEvent ( EventEntity event ) {
        this.event = event;
    }
}
