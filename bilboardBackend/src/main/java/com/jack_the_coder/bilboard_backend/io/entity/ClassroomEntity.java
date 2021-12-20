package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the classrooms in database
 * @implNote DONE
 * @since 11.11.2021
 */
@Entity( name = "classrooms" )
public class ClassroomEntity implements Serializable {

    private static final long serialVersionUID = -7994542806569385225L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "name", length = 45, nullable = false )
    private String name;

    @ManyToOne( targetEntity = BuildingEntity.class )
    @JoinColumn( name = "building" )
    private BuildingEntity building;

    @Column( name = "capacity" )
    private int capacity;

    @OneToMany( targetEntity = ClassroomDayEntity.class, mappedBy = "classroom" )
    private List<ClassroomDayEntity> classroomDays;

    /**
     * get Capacity of class method
     * @return capacity as an integer
     */
    public int getCapacity () {
        return capacity;
    }

    /**
     * set capacity of class method
     * @param capacity is an integer
     */
    public void setCapacity ( int capacity ) {
        this.capacity = capacity;
    }

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
     * Get building method
     * @return BuildingEntity object
     */
    public BuildingEntity getBuilding () {
        return building;
    }

    /**
     * Set building method
     * @param building is BuildingEntity instance
     */
    public void setBuilding ( BuildingEntity building ) {
        this.building = building;
    }

    /**
     * Get classroom days method
     * @return ClassroomDayEntity list
     */
    public List<ClassroomDayEntity> getClassroomDays () {
        return classroomDays;
    }

    /**
     * Set classrooms days method
     * @param classroomDays is ClassroomDayEntity list
     */
    public void setClassroomDays (
            List<ClassroomDayEntity> classroomDays ) {
        this.classroomDays = classroomDays;
    }
}
