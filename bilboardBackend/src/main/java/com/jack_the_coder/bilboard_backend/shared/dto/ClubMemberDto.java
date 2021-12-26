package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the club members
 * @implNote DONE
 * @since 20.12.2021
 */
public class ClubMemberDto implements Serializable {

    private static final long serialVersionUID = -4301452349296781115L;

    private long id;
    private int attendedEventCount;
    private int gePoint;
    private UserEntity user;
    private ClubEntity club;

    /**
     * get id method
     * @return id is a long
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
     * get attended event count gives number of event member attend
     * @return attendedEventCount is an integer
     */
    public int getAttendedEventCount () {
        return attendedEventCount;
    }

    /**
     * set attended event count
     * @param attendedEventCount is an integer parameter
     */
    public void setAttendedEventCount ( int attendedEventCount ) {
        this.attendedEventCount = attendedEventCount;
    }

    /**
     * get ge point method
     * @return gePoint is an integer
     */
    public int getGePoint () {
        return gePoint;
    }

    /**
     * set ge point method
     * @param gePoint is an integer parameter
     */
    public void setGePoint ( int gePoint ) {
        this.gePoint = gePoint;
    }

    /**
     * get user method
     * @return user is an UserEntity instance
     */
    public UserEntity getUser () {
        return user;
    }

    /**
     * set user method
     * @param user is a UserEntity instance parameter
     */
    public void setUser ( UserEntity user ) {
        this.user = user;
    }

    /**
     * get club method
     * @return club is a ClubEntity instance
     */
    public ClubEntity getClub () {
        return club;
    }

    /**
     * set club method
     * @param club is a ClubEntity instance parameter
     */
    public void setClub ( ClubEntity club ) {
        this.club = club;
    }
}
