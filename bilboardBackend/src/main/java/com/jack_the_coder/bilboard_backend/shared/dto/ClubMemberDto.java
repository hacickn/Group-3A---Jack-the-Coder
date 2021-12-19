package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the club members
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class ClubMemberDto implements Serializable {

    private static final long serialVersionUID = -4301452349296781115L;

    private long id;
    private int attendedEventCount;
    private int gePoint;
    private UserEntity user;
    private ClubEntity club;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public int getAttendedEventCount () {
        return attendedEventCount;
    }

    public void setAttendedEventCount ( int attendedEventCount ) {
        this.attendedEventCount = attendedEventCount;
    }

    public int getGePoint () {
        return gePoint;
    }

    public void setGePoint ( int gePoint ) {
        this.gePoint = gePoint;
    }

    public UserEntity getUser () {
        return user;
    }

    public void setUser ( UserEntity user ) {
        this.user = user;
    }

    public ClubEntity getClub () {
        return club;
    }

    public void setClub ( ClubEntity club ) {
        this.club = club;
    }
}
