package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Aslı Dinç and Hacı Çakın
 * @apiNote This class is base structure of the club_feedbacks in database
 * @implNote DONE
 * @since 11.11.2021
 */
@Entity( name = "club_feedbacks" )
public class ClubFeedbackEntity implements Serializable {

    private static final long serialVersionUID = -3993542896569185356L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "content", length = 300, nullable = false )
    private String content;

    @Column( name = "date", nullable = false )
    private Date date;

    @Column( name = "status" )
    private boolean status;

    @ManyToOne( targetEntity = ClubEntity.class )
    @JoinColumn( name = "club" )
    private ClubEntity club;

    @ManyToOne( targetEntity = UserEntity.class )
    @JoinColumn( name = "user" )
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
