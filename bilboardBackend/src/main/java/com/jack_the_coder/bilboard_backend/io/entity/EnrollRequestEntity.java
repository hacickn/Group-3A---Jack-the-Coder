package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Hacı Çakın, Aslı Dinç
 * @apiNote This class is base structure of the EnrollRequestEntity table in database
 * @implNote DONE
 * @since 11.12.2021
 */
@Entity( name = "enroll_requests" )
public class EnrollRequestEntity implements Serializable {

    public enum RequestStatus {
        created,
        pending,
        accepted,
        denied
    }

    private static final long serialVersionUID = 2973689029161705575L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @ManyToOne( targetEntity = UserEntity.class )
    @JoinColumn( name = "user" )
    private UserEntity user;

    @ManyToOne( targetEntity = ClubEntity.class )
    @JoinColumn( name = "club" )
    private ClubEntity club;

    @Column( name = "created_at" )
    private Date createdAt;

    @Enumerated( EnumType.STRING )
    @Column( name = "status" )
    private EnrollRequestEntity.RequestStatus status;

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
     * get user method
     * @return user is a UserEntity instance
     */
    public UserEntity getUser () {
        return user;
    }

    /**
     * set user method
     * @param user is a UserEntity instance
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
     * @param club is a ClubEntity instance
     */
    public void setClub ( ClubEntity club ) {
        this.club = club;
    }

    /**
     * get created at method
     * @return createdAt is a Date
     */
    public Date getCreatedAt () {
        return createdAt;
    }

    /**
     * set created at method
     * @param createdAt is a Date
     */
    public void setCreatedAt ( Date createdAt ) {
        this.createdAt = createdAt;
    }

    /**
     * get status method
     * @return status is a RequestStatus
     */
    public RequestStatus getStatus () {
        return status;
    }

    /**
     * set status method
     * @param status is a RequestStatus
     */
    public void setStatus ( RequestStatus status ) {
        this.status = status;
    }
}
