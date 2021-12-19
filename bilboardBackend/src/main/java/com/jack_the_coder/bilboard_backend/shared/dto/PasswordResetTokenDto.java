package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the password reset tokens
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class PasswordResetTokenDto implements Serializable {

    private static final long serialVersionUID = -7004077151911013223L;

    private long id;
    private String token;
    private UserEntity userDetails;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getToken () {
        return token;
    }

    public void setToken ( String token ) {
        this.token = token;
    }

    public UserEntity getUserDetails () {
        return userDetails;
    }

    public void setUserDetails ( UserEntity userDetails ) {
        this.userDetails = userDetails;
    }
}
