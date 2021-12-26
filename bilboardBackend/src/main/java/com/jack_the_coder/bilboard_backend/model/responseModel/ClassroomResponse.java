package com.jack_the_coder.bilboard_backend.model.responseModel;

import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class ClassroomResponse {
    private long id;
    private String name;
    private int capacity;
    private List<ClassroomDayResponse> classroomDays;

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
     * Get classroom days method
     * @return ClassroomDayResponse list
     */
    public List<ClassroomDayResponse> getClassroomDays () {
        return classroomDays;
    }

    /**
     * Set classroom days method
     * @param classroomDays is ClassroomDayResponse list
     */
    public void setClassroomDays (
            List<ClassroomDayResponse> classroomDays ) {
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
