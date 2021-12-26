package com.jack_the_coder.bilboard_backend.model.responseModel;

import java.util.Date;

/**
 * @author Hacı Çakın
 * @apiNote Error model as a response, it consist of message and time info
 * @implNote DONE
 * @since 05.12.2021
 */
public class ErrorMessage {
    private Date timestamp;
    private String message;

    public ErrorMessage () {
    }

    /**
     * @param timestamp is a Date parameter
     * @param message   is a String parameter
     */
    public ErrorMessage ( Date timestamp , String message ) {
        this.timestamp = timestamp;
        this.message = message;
    }

    /**
     * Get timestamp method
     * @return Date
     */
    public Date getTimestamp () {
        return timestamp;
    }

    /**
     * Set timestamp method
     * @param timestamp is a Date parameter
     */
    public void setTimestamp ( Date timestamp ) {
        this.timestamp = timestamp;
    }

    /**
     * Get message method
     * @return String
     */
    public String getMessage () {
        return message;
    }

    /**
     * Set message method
     * @param message is a String parameter
     */
    public void setMessage ( String message ) {
        this.message = message;
    }
}