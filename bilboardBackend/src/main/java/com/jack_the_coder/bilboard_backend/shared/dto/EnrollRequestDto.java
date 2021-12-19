package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.EnrollRequestEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the enroll requests
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class EnrollRequestDto implements Serializable {

    private static final long serialVersionUID = -7004079159911053223L;

    private long id;
    private UserEntity user;
    private ClubEntity club;
    private Date createdAt;
    private EnrollRequestEntity.RequestStatus status;

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

    public EnrollRequestEntity.RequestStatus getStatus () {
        return status;
    }

    public void setStatus ( EnrollRequestEntity.RequestStatus status ) {
        this.status = status;
    }
}
