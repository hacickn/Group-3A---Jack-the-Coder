package com.jack_the_coder.bilboard_backend.model.responseModel;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class ClubSponsorshipResponse {
    private long id;
    private String name;
    private String photo;
    private int amount;
    private String type;

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
     * Get photo method
     * @return String
     */
    public String getPhoto () {
        return photo;
    }

    /**
     * Set photo method
     * @param photo is String
     */
    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    /**
     * Get amount method
     * @return int
     */
    public int getAmount () {
        return amount;
    }

    /**
     * Set amount method
     * @param amount is int
     */
    public void setAmount ( int amount ) {
        this.amount = amount;
    }

    /**
     * Get type method
     * @return String
     */
    public String getType () {
        return type;
    }

    /**
     * Set photo method
     * @param type is String
     */
    public void setType ( String type ) {
        this.type = type;
    }
}
