package com.jack_the_coder.bilboard_backend.model.responseModel;

public class CreateClubResponse {

    private long id;
    private CreateUniversityResponse university;
    private String name;
    private String shortName;
    private String wpLink;
    private String instaLink;
    private String photo;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public CreateUniversityResponse getUniversity () {
        return university;
    }

    public void setUniversity ( CreateUniversityResponse university ) {
        this.university = university;
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

    public String getPhoto () {
        return photo;
    }

    public void setPhoto ( String photo ) {
        this.photo = photo;
    }
}
