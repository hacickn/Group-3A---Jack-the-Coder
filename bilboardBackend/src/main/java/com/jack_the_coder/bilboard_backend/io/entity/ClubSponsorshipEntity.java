package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the club sponsorship in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 11.11.2021
 */
@Entity( name = "club_sponsorships" )
public class ClubSponsorshipEntity implements Serializable {

    private static final long serialVersionUID = -1993543896577785356L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "name", length = 45, nullable = false )
    private String name;

    @Column( name = "photo", length = 45 )
    private String photo;

    @Column( name = "amount" )
    private int amount;

    @Column( name = "type", length = 45 )
    private String type;

    @ManyToOne( targetEntity = ClubEntity.class )
    @JoinColumn( name = "club" )
    private ClubEntity club;

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
     * Get name method
     * @return String
     */
    public String getName () {
        return name;
    }

    /**
     * Set name method
     * @param name is String
     */
    public void setName ( String name ) {
        this.name = name;
    }

    /**
     * Get photo method
     * @return String
     */
    public String getPhoto () {
        return photo;
    }

    /**
     * Set photo method
     * @param photo is String
     */
    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    /**
     * Get amount method
     * @return int
     */
    public int getAmount () {
        return amount;
    }

    /**
     * Set amount method
     * @param amount is int
     */
    public void setAmount ( int amount ) {
        this.amount = amount;
    }

    /**
     * Get type method
     * @return String
     */
    public String getType () {
        return type;
    }

    /**
     * Set photo method
     * @param type is String
     */
    public void setType ( String type ) {
        this.type = type;
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
}
