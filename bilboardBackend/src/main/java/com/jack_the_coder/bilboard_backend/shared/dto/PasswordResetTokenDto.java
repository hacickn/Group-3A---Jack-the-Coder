package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the password reset tokens
 * @implNote DONE
 * @since 20.12.2021
 */
public class PasswordResetTokenDto implements Serializable {

    private static final long serialVersionUID = -7004077151911013223L;

    private long id;
    private String token;
    private UserEntity userDetails;

    /**
     * Get id method
     * @return the id
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id which is a long parameter
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Get token method
     * @return the token
     */
    public String getToken () {
        return token;
    }

    /**
     * Set token method
     * @param token which is a String parameter
     */
    public void setToken ( String token ) {
        this.token = token;
    }

    /**
     * Get userDetails method
     * @return UserEntity
     */
    public UserEntity getUserDetails () {
        return userDetails;
    }

    /**
     * Set userDetails method
     * @param userDetails which is a UserEntity parameter
     */
    public void setUserDetails ( UserEntity userDetails ) {
        this.userDetails = userDetails;
    }
}
