package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;

import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the club sponsorship
 * @implNote NOT Completed
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

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getPhoto () {
        return photo;
    }

    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    public int getAmount () {
        return amount;
    }

    public void setAmount ( int amount ) {
        this.amount = amount;
    }

    public String getType () {
        return type;
    }

    public void setType ( String type ) {
        this.type = type;
    }

    public ClubEntity getClub () {
        return club;
    }

    public void setClub ( ClubEntity club ) {
        this.club = club;
    }
}
