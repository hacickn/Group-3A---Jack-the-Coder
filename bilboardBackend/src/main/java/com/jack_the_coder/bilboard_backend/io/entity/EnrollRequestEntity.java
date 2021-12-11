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

    // todo
    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
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

    public Date getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt ( Date createdAt ) {
        this.createdAt = createdAt;
    }

    public RequestStatus getStatus () {
        return status;
    }

    public void setStatus ( RequestStatus status ) {
        this.status = status;
    }
}
