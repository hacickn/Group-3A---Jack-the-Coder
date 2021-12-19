package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClassroomEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UniversityEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the buildings
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class BuildingDto implements Serializable {

    private static final long serialVersionUID = -4801424319396881115L;

    private long id;
    private String name;
    private UniversityEntity university;
    private List<ClassroomEntity> classrooms;

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

    public UniversityEntity getUniversity () {
        return university;
    }

    public void setUniversity ( UniversityEntity university ) {
        this.university = university;
    }

    public List<ClassroomEntity> getClassrooms () {
        return classrooms;
    }

    public void setClassrooms ( List<ClassroomEntity> classrooms ) {
        this.classrooms = classrooms;
    }
}
