package com.jack_the_coder.bilboard_backend.model.requestModel;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to create a classroom
 * @implNote DONE
 * @since 05.12.2021
 */
public class CreateClassroomRequest {

    private String name;
    private int capacity;
    private long building;

    /**
     * get name method
     * @return name is String
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
     * get building method
     * @return building is long
     */
    public long getBuilding () {
        return building;
    }

    /**
     * Set building method
     * @param building is long
     */
    public void setBuilding ( long building ) {
        this.building = building;
    }

    /**
     * get capacity method
     * @return capacity is int
     */
    public int getCapacity () {
        return capacity;
    }

    /**
     * Set capacity method
     * @param capacity is int
     */
    public void setCapacity ( int capacity ) {
        this.capacity = capacity;
    }
}
