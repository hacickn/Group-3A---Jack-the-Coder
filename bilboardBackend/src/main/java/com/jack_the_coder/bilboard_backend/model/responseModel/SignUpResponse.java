package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class SignUpResponse {
    private long id;
    private CreateUniversityResponse university;
    private String name;
    private String surname;
    private String email;
    private String bilkentId;
    private boolean emailConfirmation;
    private UserEntity.UserTypes type;

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
     * Get university method
     * @return CreateUniversityResponse
     */
    public CreateUniversityResponse getUniversity () {
        return university;
    }

    /**
     * Set university method
     * @param university is CreateUniversityResponse
     */
    public void setUniversity ( CreateUniversityResponse university ) {
        this.university = university;
    }

    /**
     * Get name method
     * @return String
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
     * Get surname method
     * @return String
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
     * Get email method
     * @return String
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

    /**
     * Get bilkentId method
     * @return String
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
     * Get emailConfirmation method
     * @return boolean
     */
    public boolean isEmailConfirmation () {
        return emailConfirmation;
    }

    /**
     * Set emailConfirmation method
     * @param emailConfirmation is boolean
     */
    public void setEmailConfirmation ( boolean emailConfirmation ) {
        this.emailConfirmation = emailConfirmation;
    }

    /**
     * Get type method
     * @return UserEntity.UserTypes
     */
    public UserEntity.UserTypes getType () {
        return type;
    }

    /**
     * Set type method
     * @param type is UserEntity.UserTypes
     */
    public void setType ( UserEntity.UserTypes type ) {
        this.type = type;
    }
}
