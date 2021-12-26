package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;

public class AdminClubResponse {
    private long id;
    private String name;
    private String shortName;
    private String photo;
    private BasicUserResponse president;
    private BasicUserResponse advisor;

    /**
     * get id method
     * @return id is a long
     */
    public long getId () {
        return id;
    }

    /**
     * set id method
     * @param id is a long
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
     * @param name is a String
     */
    public void setName ( String name ) {
        this.name = name;
    }

    /**
     * Get short name method
     * @return String
     */
    public String getShortName () {
        return shortName;
    }

    /**
     * Set short name method
     * @param shortName is String
     */
    public void setShortName ( String shortName ) {
        this.shortName = shortName;
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
     * Get president method
     * @return BasicUserResponse
     */
    public BasicUserResponse getPresident () {
        return president;
    }

    /**
     * Set president method
     * @param president is BasicUserResponse
     */
    public void setPresident (
            BasicUserResponse president ) {
        this.president = president;
    }

    /**
     * Get advisor method
     * @return BasicUserResponse
     */
    public BasicUserResponse getAdvisor () {
        return advisor;
    }

    /**
     * Set advisor method
     * @param advisor is BasicUserResponse
     */
    public void setAdvisor (
            BasicUserResponse advisor ) {
        this.advisor = advisor;
    }
}
