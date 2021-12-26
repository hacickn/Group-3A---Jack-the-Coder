package com.jack_the_coder.bilboard_backend.model.requestModel;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to create a university
 * @implNote DONE
 * @since 05.12.2021
 */
public class CreateUniversityRequest {
    private String name;

    /**
     * get university method
     * @return university is String
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
