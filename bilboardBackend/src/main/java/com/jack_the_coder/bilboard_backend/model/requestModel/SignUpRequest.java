package com.jack_the_coder.bilboard_backend.model.requestModel;

import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to sign up
 * @implNote DONE
 * @since 05.12.2021
 */
public class SignUpRequest {
    private long university;
    private String name;
    private String surname;
    private String password;
    private String bilkentId;
    private String email;
    private UserEntity.UserTypes type;

    /**
     * get university method
     * @return university is long
     */
    public long getUniversity () {
        return university;
    }

    /**
     * Set university method
     * @param university is long
     */
    public void setUniversity ( long university ) {
        this.university = university;
    }

    /**
     * get type method
     * @return type is UserTypes
     */
    public UserEntity.UserTypes getType () {
        return type;
    }

    /**
     * Set type method
     * @param type is UserTypes
     */
    public void setType ( UserEntity.UserTypes type ) {
        this.type = type;
    }

    /**
     * get name method
     * @return name is String
     */
    public String getName () {
        return name;
    }

    /**
     * Set name method
     * @param name is String
     */
    public void setName ( String name ) {
        this.name = name;
    }

    /**
     * get surname method
     * @return surname is String
     */
    public String getSurname () {
        return surname;
    }

    /**
     * Set surname method
     * @param surname is String
     */
    public void setSurname ( String surname ) {
        this.surname = surname;
    }

    /**
     * get password method
     * @return password is String
     */
    public String getPassword () {
        return password;
    }

    /**
     * Set password method
     * @param password is String
     */
    public void setPassword ( String password ) {
        this.password = password;
    }

    /**
     * get bilkentId method
     * @return bilkentId is String
     */
    public String getBilkentId () {
        return bilkentId;
    }

    /**
     * Set bilkentId method
     * @param bilkentId is String
     */
    public void setBilkentId ( String bilkentId ) {
        this.bilkentId = bilkentId;
    }

    /**
     * get email method
     * @return email is String
     */
    public String getEmail () {
        return email;
    }

    /**
     * Set email method
     * @param email is String
     */
    public void setEmail ( String email ) {
        this.email = email;
    }
}
