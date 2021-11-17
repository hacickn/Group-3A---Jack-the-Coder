package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the event participants in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 11.11.2021
 */
@Entity( name = "event_participants" )
public class EventParticipantEntity implements Serializable {

    private static final long serialVersionUID = -3993666986569385225L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "is_attended" )
    private Boolean isAttended;

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
     * Set id method
     * @param id is an long parameter
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Get attended method
     * @return Boolean
     */
    public Boolean getAttended () {
        return isAttended;
    }

    /**
     * Set attended method
     * @param attended is Boolean
     */
    public void setAttended ( Boolean attended ) {
        isAttended = attended;
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
     * @param user is UserEntity
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
     * @param event is EventEntity
     */
    public void setEvent ( EventEntity event ) {
        this.event = event;
    }
}
