package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the event_points table in database
 * @implNote DONE
 * @since 09.11.2021
 */
@Entity( name = "event_points" )
public class EventPointEntity implements Serializable {

    private static final long serialVersionUID = -4702982175549963977L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "point" )
    private int point;

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
     * Get point method
     * @return int
     */
    public int getPoint () {
        return point;
    }

    /**
     * Set point method
     * @param point is an int
     */
    public void setPoint ( int point ) {
        this.point = point;
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
