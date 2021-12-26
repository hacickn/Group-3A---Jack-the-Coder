package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.EnrollRequestEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the enroll requests
 * @implNote DONE
 * @since 20.12.2021
 */
public class EnrollRequestDto implements Serializable {

    private static final long serialVersionUID = -7004079159911053223L;

    private long id;
    private UserEntity user;
    private ClubEntity club;
    private Date createdAt;
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
    public EnrollRequestEntity.RequestStatus getStatus () {
        return status;
    }

    /**
     * set status method
     * @param status is a RequestStatus
     */
    public void setStatus ( EnrollRequestEntity.RequestStatus status ) {
        this.status = status;
    }
}
