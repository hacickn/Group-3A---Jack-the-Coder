package com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel;

import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

public class BasicUserResponse {

    private long id;
    private String name;
    private String surname;
    private String photo;
    private String bilkentId;
    private UserEntity.UserTypes type;

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

    public String getSurname () {
        return surname;
    }

    public void setSurname ( String surname ) {
        this.surname = surname;
    }

    public String getPhoto () {
        return photo;
    }

    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    public String getBilkentId () {
        return bilkentId;
    }

    public void setBilkentId ( String bilkentId ) {
        this.bilkentId = bilkentId;
    }

    public UserEntity.UserTypes getType () {
        return type;
    }

    public void setType ( UserEntity.UserTypes type ) {
        this.type = type;
    }
}
