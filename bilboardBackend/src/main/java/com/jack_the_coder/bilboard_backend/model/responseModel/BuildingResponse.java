package com.jack_the_coder.bilboard_backend.model.responseModel;

import java.util.List;

public class BuildingResponse {

    private long id;
    private String name;
    private List<ClassroomResponse> classrooms;

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

    public List<ClassroomResponse> getClassrooms () {
        return classrooms;
    }

    public void setClassrooms (
            List<ClassroomResponse> classrooms ) {
        this.classrooms = classrooms;
    }
}
