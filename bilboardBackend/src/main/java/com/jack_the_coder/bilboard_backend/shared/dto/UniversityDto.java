package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.BuildingEntity;
import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the university
 * @implNote DONE
 * @since 20.12.2021
 */
public class UniversityDto {

    private long id;
    private String name;
    private List<UserEntity> users;
    private List<ClubEntity> clubs;
    private List<BuildingEntity> buildings;

    /**
     * Get id method
     * @return long
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id is a long parameter
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
     * @param name is a String parameter
     */
    public void setName ( String name ) {
        this.name = name;
    }

    /**
     * Get users method
     * @return List<UserEntity>
     */
    public List<UserEntity> getUsers () {
        return users;
    }

    /**
     * Set users method
     * @param users is a List<UserEntity> parameter
     */
    public void setUsers ( List<UserEntity> users ) {
        this.users = users;
    }

    /**
     * Get clubs method
     * @return List<ClubEntity>
     */
    public List<ClubEntity> getClubs () {
        return clubs;
    }

    /**
     * Set clubs method
     * @param clubs is a List<ClubEntity> parameter
     */
    public void setClubs ( List<ClubEntity> clubs ) {
        this.clubs = clubs;
    }

    /**
     * Get buildings method
     * @return List<BuildingEntity>
     */
    public List<BuildingEntity> getBuildings () {
        return buildings;
    }

    /**
     * Set buildings method
     * @param buildings is a List<BuildingEntity> parameter
     */
    public void setBuildings ( List<BuildingEntity> buildings ) {
        this.buildings = buildings;
    }
}
