package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.LocationRequestEntity;
import com.jack_the_coder.bilboard_backend.io.entity.TimeSlotEntity;

import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the location request time slots
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class LocationRequestTimeSlotDto implements Serializable {

    private static final long serialVersionUID = -7114077156911053223L;

    private long id;
    private LocationRequestEntity locationRequest;
    private TimeSlotEntity timeSlot;

    /**
     * Get id method
     * @return the id
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id the id to set
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Get locationRequest method
     * @return LocationRequestEntity
     */
    public LocationRequestEntity getLocationRequest () {
        return locationRequest;
    }

    /**
     * Set locationRequest method
     * @param locationRequest the locationRequest to set
     */
    public void setLocationRequest ( LocationRequestEntity locationRequest ) {
        this.locationRequest = locationRequest;
    }

    /**
     * Get timeSlot method
     * @return TimeSlotEntity
     */
    public TimeSlotEntity getTimeSlot () {
        return timeSlot;
    }

    /**
     * Set timeSlot method
     * @param timeSlot the timeSlot to set
     */
    public void setTimeSlot ( TimeSlotEntity timeSlot ) {
        this.timeSlot = timeSlot;
    }
}
