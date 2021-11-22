package com.jack_the_coder.bilboard_backend.model.responseModel;

import java.util.Date;

/**
 * @author Hacı Çakın
 * @apiNote Error model as a response, it consist of message and time info
 * @implNote DONE
 * @since 22.11.2021
 */
public class ErrorMessage {
    private Date timestamp;
    private String message;

    public ErrorMessage () {
    }

    public ErrorMessage ( Date timestamp , String message ) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp () {
        return timestamp;
    }

    public void setTimestamp ( Date timestamp ) {
        this.timestamp = timestamp;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage ( String message ) {
        this.message = message;
    }
}