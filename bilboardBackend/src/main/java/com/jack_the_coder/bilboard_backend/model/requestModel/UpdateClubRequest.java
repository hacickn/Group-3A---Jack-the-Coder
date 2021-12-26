package com.jack_the_coder.bilboard_backend.model.requestModel;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to update club
 * @implNote DONE
 * @since 05.12.2021
 */
public class UpdateClubRequest {

    private long id;
    private String name;
    private String shortName;
    private String wpLink;
    private String instaLink;

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

    public String getShortName () {
        return shortName;
    }

    public void setShortName ( String shortName ) {
        this.shortName = shortName;
    }

    public String getWpLink () {
        return wpLink;
    }

    public void setWpLink ( String wpLink ) {
        this.wpLink = wpLink;
    }

    public String getInstaLink () {
        return instaLink;
    }

    public void setInstaLink ( String instaLink ) {
        this.instaLink = instaLink;
    }
}
