package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.EventEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the event participants
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class EventParticipantDto implements Serializable {

    private static final long serialVersionUID = -4701451319296781115L;

    private long id;
    private Boolean isAttended;
    private UserEntity user;
    private EventEntity event;
    private Boolean pointGiven;
    private int point;

    /**
     * Get id method
     * @return the id
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id the id to set
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Get isAttended method
     * @return the isAttended
     */
    public Boolean getAttended () {
        return isAttended;
    }

    /**
     * Set isAttended method
     * @param isAttended the isAttended to set
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

    /**
     * Get point method
     * @return int
     */
    public int getPoint () {
        return point;
    }

    /**
     * Set point method
     * @param point is int
     */
    public void setPoint ( int point ) {
        this.point = point;
    }

    /**
     * Get pointGiven method
     * @return Boolean
     */
    public Boolean getPointGiven () {
        return pointGiven;
    }

    /**
     * Set pointGiven method
     * @param pointGiven is Boolean
     */
    public void setPointGiven ( Boolean pointGiven ) {
        this.pointGiven = pointGiven;
    }
}
