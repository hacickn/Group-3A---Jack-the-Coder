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
    private int point;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public Boolean getAttended () {
        return isAttended;
    }

    public void setAttended ( Boolean attended ) {
        isAttended = attended;
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

    public int getPoint () {
        return point;
    }

    public void setPoint ( int point ) {
        this.point = point;
    }
}
