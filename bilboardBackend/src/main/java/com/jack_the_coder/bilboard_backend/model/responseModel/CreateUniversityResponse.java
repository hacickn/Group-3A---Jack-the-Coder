package com.jack_the_coder.bilboard_backend.model.responseModel;


public class CreateUniversityResponse {

    private long id;
    private String name;

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
}
