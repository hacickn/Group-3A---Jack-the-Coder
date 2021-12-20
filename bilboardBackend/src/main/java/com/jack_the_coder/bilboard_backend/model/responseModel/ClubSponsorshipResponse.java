package com.jack_the_coder.bilboard_backend.model.responseModel;

public class ClubSponsorshipResponse {
    private long id;
    private String name;
    private String photo;
    private int amount;
    private String type;

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
}
