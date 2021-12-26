package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UniversityEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class UserResponse {

    private long id;
    private String name;
    private String surname;
    private UserEntity.UserTypes type;
    private String bilkentId;
    private String photo;
    private String email;
    private boolean geTaken;
    private BasicClubResponse presidentOf;
    private BasicClubResponse advisorOf;
    private CreateUniversityResponse university;

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
     * Get ge status method
     * @return boolean
     */
    public boolean isGeTaken () {
        return geTaken;
    }

    /**
     * Set ge status method
     * @param geTaken is boolean
     */
    public void setGeTaken ( boolean geTaken ) {
        this.geTaken = geTaken;
    }

    /**
     * Get presidentOf method
     * @return BasicClubResponse
     */
    public BasicClubResponse getPresidentOf () {
        return presidentOf;
    }

    /**
     * Set presidentOf method
     * @param presidentOf is BasicClubResponse
     */
    public void setPresidentOf (
            BasicClubResponse presidentOf ) {
        this.presidentOf = presidentOf;
    }

    /**
     * Get advisorOf method
     * @return BasicClubResponse
     */
    public BasicClubResponse getAdvisorOf () {
        return advisorOf;
    }

    /**
     * Set advisorOf method
     * @param advisorOf is BasicClubResponse
     */
    public void setAdvisorOf (
            BasicClubResponse advisorOf ) {
        this.advisorOf = advisorOf;
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
     * Get photo method
     * @return String
     */
    public String getPhoto () {
        return photo;
    }

    /**
     * Set photo method
     * @param photo is String
     */
    public void setPhoto ( String photo ) {
        this.photo = photo;
    }
}
