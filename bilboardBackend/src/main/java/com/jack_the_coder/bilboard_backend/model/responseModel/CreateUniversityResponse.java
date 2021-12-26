package com.jack_the_coder.bilboard_backend.model.responseModel;


public class CreateUniversityResponse {

    private long id;
    private String name;

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
}
