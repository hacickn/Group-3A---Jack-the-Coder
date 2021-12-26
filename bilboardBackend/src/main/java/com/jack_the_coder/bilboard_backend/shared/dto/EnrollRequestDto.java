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

    /**
     * @apiNote This method is used to set the id of the EnrollRequestEntity
     * @implNote DONE
     * @param id the id of the EnrollRequestEntity
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * @apiNote This method is used to get the user of the EnrollRequestEntity
     * @implNote DONE
     * @return the user of the EnrollRequestEntity
     */
    public UserEntity getUser () {
        return user;
    }

    /**
     * @apiNote This method is used to set the user of the EnrollRequestEntity
     * @implNote DONE
     * @param user the user of the EnrollRequestEntity
     */
    public void setUser ( UserEntity user ) {
        this.user = user;
    }

    /**
     * @apiNote This method is used to get the club of the EnrollRequestEntity
     * @implNote DONE
     * @return the club of the EnrollRequestEntity
     */
    public ClubEntity getClub () {
        return club;
    }

    /**
     * @apiNote This method is used to set the club of the EnrollRequestEntity
     * @implNote DONE
     * @param club the club of the EnrollRequestEntity
     */
    public void setClub ( ClubEntity club ) {
        this.club = club;
    }

    /**
     * @apiNote This method is used to get the createdAt of the EnrollRequestEntity
     * @implNote DONE
     * @return the createdAt of the EnrollRequestEntity
     */
    public Date getCreatedAt () {
        return createdAt;
    }

    /**
     * @apiNote This method is used to set the createdAt of the EnrollRequestEntity
     * @implNote DONE
     * @param createdAt the createdAt of the EnrollRequestEntity
     */
    public void setCreatedAt ( Date createdAt ) {
        this.createdAt = createdAt;
    }

    /**
     * @apiNote This method is used to get the status of the EnrollRequestEntity
     * @implNote DONE
     * @return the status of the EnrollRequestEntity
     */
    public EnrollRequestEntity.RequestStatus getStatus () {
        return status;
    }

    /**
     * @apiNote This method is used to set the status of the EnrollRequestEntity
     * @implNote DONE
     * @param status the status of the EnrollRequestEntity
     */
    public void setStatus ( EnrollRequestEntity.RequestStatus status ) {
        this.status = status;
    }
}
