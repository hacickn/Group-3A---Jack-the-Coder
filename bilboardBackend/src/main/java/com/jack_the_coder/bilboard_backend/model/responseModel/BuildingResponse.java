package com.jack_the_coder.bilboard_backend.model.responseModel;

import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class BuildingResponse {

    private long id;
    private String name;
    private List<ClassroomResponse> classrooms;

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
     * Get classrooms method
     * @return ClassroomResponse
     */
    public List<ClassroomResponse> getClassrooms () {
        return classrooms;
    }

    /**
     * Set classrooms method
     * @param classrooms is ClassroomResponse
     */
    public void setClassrooms (
            List<ClassroomResponse> classrooms ) {
        this.classrooms = classrooms;
    }
}
