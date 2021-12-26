package com.jack_the_coder.bilboard_backend.model.responseModel;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class TimeSlotResponse {
    private long id;
    private Date startTime;
    private Date endTime;

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
     * Get startTime method
     * @return Date
     */
    public Date getStartTime () {
        return startTime;
    }

    /**
     * Set startTime method
     * @param startTime is Date
     */
    public void setStartTime ( Date startTime ) {
        this.startTime = startTime;
    }

    /**
     * Get endTime method
     * @return Date
     */
    public Date getEndTime () {
        return endTime;
    }

    /**
     * Set endTime method
     * @param endTime is Date
     */
    public void setEndTime ( Date endTime ) {
        this.endTime = endTime;
    }
}
