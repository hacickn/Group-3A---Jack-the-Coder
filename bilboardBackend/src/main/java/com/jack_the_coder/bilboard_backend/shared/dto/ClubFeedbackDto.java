package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Aslı Dinç and Hacı Çakın
 * @apiNote This class is data transfer object of the club feedbacks
 * @implNote DONE
 * @since 20.12.2021
 */
public class ClubFeedbackDto implements Serializable {

    private static final long serialVersionUID = -4701452319296782315L;

    private long id;
    private String content;
    private Date date;
    private boolean status;
    private ClubEntity club;
    private UserEntity user;

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
     * Get content method
     * @return String
     */
    public String getContent () {
        return content;
    }

    /**
     * Set content method
     * @param content is String
     */
    public void setContent ( String content ) {
        this.content = content;
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
     * @param date is Date
     */
    public void setDate ( Date date ) {
        this.date = date;
    }

    /**
     * It returns the status
     * @return boolean is status
     */
    public boolean isStatus () {
        return status;
    }

    /**
     * It sets the status
     * @param status is boolean
     */
    public void setStatus ( boolean status ) {
        this.status = status;
    }

    /**
     * Get club method
     * @return ClubEntity
     */
    public ClubEntity getClub () {
        return club;
    }

    /**
     * Set club method
     * @param club is ClubEntity
     */
    public void setClub ( ClubEntity club ) {
        this.club = club;
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
}
