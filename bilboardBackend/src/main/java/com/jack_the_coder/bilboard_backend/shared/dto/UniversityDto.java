package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.BuildingEntity;
import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the university
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class UniversityDto {

    private long id;
    private String name;
    private List<UserEntity> users;
    private List<ClubEntity> clubs;
    private List<BuildingEntity> buildings;

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

    public List<UserEntity> getUsers () {
        return users;
    }

    public void setUsers ( List<UserEntity> users ) {
        this.users = users;
    }

    public List<ClubEntity> getClubs () {
        return clubs;
    }

    public void setClubs ( List<ClubEntity> clubs ) {
        this.clubs = clubs;
    }

    public List<BuildingEntity> getBuildings () {
        return buildings;
    }

    public void setBuildings ( List<BuildingEntity> buildings ) {
        this.buildings = buildings;
    }
}
