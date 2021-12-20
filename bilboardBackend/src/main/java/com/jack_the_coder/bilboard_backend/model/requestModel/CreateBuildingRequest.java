package com.jack_the_coder.bilboard_backend.model.requestModel;

public class CreateBuildingRequest {

    private String name;
    private long university;

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public long getUniversity () {
        return university;
    }

    public void setUniversity ( long university ) {
        this.university = university;
    }
}
