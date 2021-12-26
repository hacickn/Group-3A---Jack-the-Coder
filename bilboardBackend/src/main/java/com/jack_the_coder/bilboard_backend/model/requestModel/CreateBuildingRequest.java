package com.jack_the_coder.bilboard_backend.model.requestModel;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to create a building
 * @implNote DONE
 * @since 05.12.2021
 */
public class CreateBuildingRequest {

    private String name;
    private long university;

    /**
     * get name method
     * @return name is String
     */
    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    /**
     * get university method
     * @return university is String
     */
    public long getUniversity () {
        return university;
    }

    public void setUniversity ( long university ) {
        this.university = university;
    }
}
