package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Hacı Çakın and Aslı Dinç
 * @apiNote This class is base structure of the universities table in database
 * @implNote DONE
 * @since 09.11.2021
 */
@Entity( name = "universities" )
public class UniversityEntity implements Serializable {

    private static final long serialVersionUID = 1615442836719692232L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "name", length = 100, nullable = false )
    private String name;

    @OneToMany( targetEntity = UserEntity.class, mappedBy = "university" )
    private List<UserEntity> users;

    @OneToMany( targetEntity = ClubEntity.class, mappedBy = "university" )
    private List<ClubEntity> clubs;

    @OneToMany( targetEntity = BuildingEntity.class, mappedBy = "university" )
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
     * Get users method
     * @return UserEntity list
     */
    public List<UserEntity> getUsers () {
        return users;
    }

    /**
     * Set users method
     * @param users is UserEntity list
     */
    public void setUsers ( List<UserEntity> users ) {
        this.users = users;
    }

    /**
     * Get clubs method
     * @return ClubEntity list
     */
    public List<ClubEntity> getClubs () {
        return clubs;
    }

    /**
     * Set clubs method
     * @param clubs is ClubEntity list
     */
    public void setClubs ( List<ClubEntity> clubs ) {
        this.clubs = clubs;
    }

    /**
     * Get buildings method
     * @return BuildingEntity list
     */
    public List<BuildingEntity> getBuildings () {
        return buildings;
    }

    /**
     * Set buildings method
     * @param buildings is BuildingEntity list
     */
    public void setBuildings ( List<BuildingEntity> buildings ) {
        this.buildings = buildings;
    }
}
