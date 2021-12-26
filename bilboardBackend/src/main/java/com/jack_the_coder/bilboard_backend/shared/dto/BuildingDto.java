package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClassroomEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UniversityEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the buildings
 * @implNote DONE
 * @since 20.12.2021
 */
public class BuildingDto implements Serializable {

    private static final long serialVersionUID = -4801424319396881115L;

    private long id;
    private String name;
    private UniversityEntity university;
    private List<ClassroomEntity> classrooms;

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
     * Get university method
     * @return UniversityEntity object
     */
    public UniversityEntity getUniversity () {
        return university;
    }

    /**
     * Set university method
     * @param university is UniversityEntity instance
     */
    public void setUniversity ( UniversityEntity university ) {
        this.university = university;
    }

    /**
     * Get classrooms method
     * @return ClassroomEntity list
     */
    public List<ClassroomEntity> getClassrooms () {
        return classrooms;
    }

    /**
     * Set classrooms method
     * @param classrooms is ClassroomEntity list
     */
    public void setClassrooms ( List<ClassroomEntity> classrooms ) {
        this.classrooms = classrooms;
    }
}
