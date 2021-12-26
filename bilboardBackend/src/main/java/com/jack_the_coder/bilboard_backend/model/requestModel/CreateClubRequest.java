package com.jack_the_coder.bilboard_backend.model.requestModel;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to create a club
 * @implNote DONE
 * @since 05.12.2021
 */
public class CreateClubRequest {

    private long university;
    private String name;
    private String shortName;

    /**
     * get university method
     * @return university is long
     */
    public long getUniversity () {
        return university;
    }

    public void setUniversity ( long university ) {
        this.university = university;
    }

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
     * get shortName method
     * @return shortName is String
     */
    public String getShortName () {
        return shortName;
    }

    public void setShortName ( String shortName ) {
        this.shortName = shortName;
    }
}
