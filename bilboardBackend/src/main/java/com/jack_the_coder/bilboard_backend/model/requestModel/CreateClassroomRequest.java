package com.jack_the_coder.bilboard_backend.model.requestModel;

public class CreateClassroomRequest {

    private String name;
    private int capacity;
    private long building;

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public long getBuilding () {
        return building;
    }

    public void setBuilding ( long building ) {
        this.building = building;
    }

    public int getCapacity () {
        return capacity;
    }

    public void setCapacity ( int capacity ) {
        this.capacity = capacity;
    }
}
