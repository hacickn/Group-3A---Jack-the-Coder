package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Hacı Çakın
 * @apiNote This class is base structure of the club_members in database
 * @implNote DONE
 * @since 11.11.2021
 */
@Entity( name = "club_members" )
public class ClubMemberEntity implements Serializable {

    private static final long serialVersionUID = -1693263068089030672L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "attended_event_count" )
    private int attendedEventCount;

    @ManyToOne( targetEntity = UserEntity.class )
    @JoinColumn( name = "user" )
    private UserEntity user;

    @ManyToOne( targetEntity = ClubEntity.class )
    @JoinColumn( name = "club" )
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
