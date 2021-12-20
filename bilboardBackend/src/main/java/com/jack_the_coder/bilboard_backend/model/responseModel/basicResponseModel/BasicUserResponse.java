package com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel;

import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

public class BasicUserResponse {

    private long id;
    private String name;
    private String surname;
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

    public UserEntity.UserTypes getType () {
        return type;
    }

    public void setType ( UserEntity.UserTypes type ) {
        this.type = type;
    }
}
