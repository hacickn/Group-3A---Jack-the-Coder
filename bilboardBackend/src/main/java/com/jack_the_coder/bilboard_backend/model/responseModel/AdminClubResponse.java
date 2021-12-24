package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;

public class AdminClubResponse {
    private long id;
    private String name;
    private String shortName;
    private String photo;
    private BasicUserResponse president;
    private BasicUserResponse advisor;

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

    public String getPhoto () {
        return photo;
    }

    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    public BasicUserResponse getPresident () {
        return president;
    }

    public void setPresident (
            BasicUserResponse president ) {
        this.president = president;
    }

    public BasicUserResponse getAdvisor () {
        return advisor;
    }

    public void setAdvisor (
            BasicUserResponse advisor ) {
        this.advisor = advisor;
    }
}
