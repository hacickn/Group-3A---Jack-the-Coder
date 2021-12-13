package com.jack_the_coder.bilboard_backend.model.requestModel;

public class CreateClubRequest {

    private long university;
    private String name;
    private String shortName;

    public long getUniversity () {
        return university;
    }

    public void setUniversity ( long university ) {
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
}
