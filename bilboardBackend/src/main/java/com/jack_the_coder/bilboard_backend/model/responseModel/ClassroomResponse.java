package com.jack_the_coder.bilboard_backend.model.responseModel;

import java.util.List;

public class ClassroomResponse {
    private long id;
    private String name;
    private int capacity;
    private List<ClassroomDayResponse> classroomDays;

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

    public List<ClassroomDayResponse> getClassroomDays () {
        return classroomDays;
    }

    public void setClassroomDays (
            List<ClassroomDayResponse> classroomDays ) {
        this.classroomDays = classroomDays;
    }

    public int getCapacity () {
        return capacity;
    }

    public void setCapacity ( int capacity ) {
        this.capacity = capacity;
    }
}
