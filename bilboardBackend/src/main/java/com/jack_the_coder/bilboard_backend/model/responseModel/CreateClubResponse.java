package com.jack_the_coder.bilboard_backend.model.responseModel;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class CreateClubResponse {

    private long id;
    private CreateUniversityResponse university;
    private String name;
    private String shortName;
    private String wpLink;
    private String instaLink;
    private String photo;

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
     * Get university method
     * @return CreateUniversityResponse
     */
    public CreateUniversityResponse getUniversity () {
        return university;
    }

    /**
     * Set university method
     * @param university is CreateUniversityResponse
     */
    public void setUniversity ( CreateUniversityResponse university ) {
        this.university = university;
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
     * Get shortName method
     * @return String
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
     * Get wpLink method
     * @return String
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
     * Get instaLink method
     * @return String
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
}
