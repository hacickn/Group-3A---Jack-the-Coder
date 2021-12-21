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
    public RequestStatus getStatus () {
        return status;
    }

    /**
     * @apiNote This method is used to set the status of the EnrollRequestEntity
     * @implNote DONE
     * @param status the status of the EnrollRequestEntity
     */
    public void setStatus ( RequestStatus status ) {
        this.status = status;
    }
}
