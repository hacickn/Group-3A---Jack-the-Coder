package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;

import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the club sponsorship
 * @implNote DONE
 * @since 20.12.2021
 */
public class ClubSponsorshipDto implements Serializable {

    private static final long serialVersionUID = 3753966812854506085L;

    private long id;
    private String name;
    private String photo;
    private int amount;
    private String type;
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
