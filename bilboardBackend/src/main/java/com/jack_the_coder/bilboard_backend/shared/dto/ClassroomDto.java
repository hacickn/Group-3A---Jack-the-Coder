package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.BuildingEntity;
import com.jack_the_coder.bilboard_backend.io.entity.ClassroomDayEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the classrooms
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class ClassroomDto implements Serializable {

    private static final long serialVersionUID = -4711551339496781115L;

    private long id;
    private String name;
    private BuildingEntity building;
    private List<ClassroomDayEntity> classroomDays;

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

    public BuildingEntity getBuilding () {
        return building;
    }

    public void setBuilding ( BuildingEntity building ) {
        this.building = building;
    }

    public List<ClassroomDayEntity> getClassroomDays () {
        return classroomDays;
    }

    public void setClassroomDays (
            List<ClassroomDayEntity> classroomDays ) {
        this.classroomDays = classroomDays;
    }
}
