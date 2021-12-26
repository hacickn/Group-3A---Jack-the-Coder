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

    /**
     * get id method
     * @return id is long
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id is long
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * get name method
     * @return name is String
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
     * get shortName method
     * @return shortName is String
     */
    public String getShortName () {
        return shortName;
    }

    /**
     * Set shortName method
     * @param shortName is String
     */
    public void setShortName ( String shortName ) {
        this.shortName = shortName;
    }

    /**
     * get wpLink method
     * @return wpLink is String
     */
    public String getWpLink () {
        return wpLink;
    }

    /**
     * Set wpLink method
     * @param wpLink is String
     */
    public void setWpLink ( String wpLink ) {
        this.wpLink = wpLink;
    }

    /**
     * get instaLink method
     * @return instaLink is String
     */
    public String getInstaLink () {
        return instaLink;
    }

    /**
     * Set instaLink method
     * @param instaLink is String
     */
    public void setInstaLink ( String instaLink ) {
        this.instaLink = instaLink;
    }
}
