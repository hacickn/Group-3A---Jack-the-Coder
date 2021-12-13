package com.jack_the_coder.bilboard_backend.model.requestModel;

import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

public class SignUpRequest {
    // todo
    private long university;
    private String name;
    private String surname;
    private String password;
    private String bilkentId;
    private String email;
    private UserEntity.UserTypes type;

    public long getUniversity () {
        return university;
    }

    public void setUniversity ( long university ) {
        this.university = university;
    }

    public UserEntity.UserTypes getType () {
        return type;
    }

    public void setType ( UserEntity.UserTypes type ) {
        this.type = type;
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

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getBilkentId () {
        return bilkentId;
    }

    public void setBilkentId ( String bilkentId ) {
        this.bilkentId = bilkentId;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }
}
