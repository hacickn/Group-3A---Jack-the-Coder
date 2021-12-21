package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the password_reset_token_entity in database
 * @implNote DONE
 * @since 10.12.2021
 */

@Entity( name = "password_reset_tokens" )
public class PasswordResetTokenEntity implements Serializable {

    private static final long serialVersionUID = -7106434375768222773L;

    @Id
    @GeneratedValue
    private long id;

    @Column( name = "token" )
    private String token;

    @OneToOne( targetEntity = UserEntity.class )
    @JoinColumn( name = "user_id" )
    private UserEntity userDetails;


    /**
     * Get id method
     * @return long
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id is an long parameter
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Get token method
     * @return String
     */
    public String getToken () {
        return token;
    }

    /**
     * Set token method
     * @param token is a String parameter
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
     * @param userDetails is a UserEntity parameter
     */
    public void setUserDetails ( UserEntity userDetails ) {
        this.userDetails = userDetails;
    }
}

