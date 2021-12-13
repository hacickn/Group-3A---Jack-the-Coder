package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

public class SignUpResponse {
    // todo
    private long id;
    private CreateUniversityResponse university;
    private String name;
    private String surname;
    private String email;
    private String bilkentId;
    private boolean emailConfirmation;
    private UserEntity.UserTypes type;

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

    public String getSurname () {
        return surname;
    }

    public void setSurname ( String surname ) {
        this.surname = surname;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getBilkentId () {
        return bilkentId;
    }

    public void setBilkentId ( String bilkentId ) {
        this.bilkentId = bilkentId;
    }

    public boolean isEmailConfirmation () {
        return emailConfirmation;
    }

    public void setEmailConfirmation ( boolean emailConfirmation ) {
        this.emailConfirmation = emailConfirmation;
    }

    public UserEntity.UserTypes getType () {
        return type;
    }

    public void setType ( UserEntity.UserTypes type ) {
        this.type = type;
    }
}
