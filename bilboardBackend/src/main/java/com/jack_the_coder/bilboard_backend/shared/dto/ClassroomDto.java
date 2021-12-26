package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.BuildingEntity;
import com.jack_the_coder.bilboard_backend.io.entity.ClassroomDayEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç and Hacı Çakın
 * @apiNote This class is data transfer object of the classrooms
 * @implNote DONE
 * @since 20.12.2021
 */
public class ClassroomDto implements Serializable {

    private static final long serialVersionUID = -4711551339496781115L;

    private long id;
    private String name;
    private BuildingEntity building;
    private int capacity;
    private List<ClassroomDayEntity> classroomDays;

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
}
