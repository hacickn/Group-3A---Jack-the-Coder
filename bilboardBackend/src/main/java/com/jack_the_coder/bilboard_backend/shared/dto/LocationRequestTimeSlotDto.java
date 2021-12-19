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

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public LocationRequestEntity getLocationRequest () {
        return locationRequest;
    }

    public void setLocationRequest ( LocationRequestEntity locationRequest ) {
        this.locationRequest = locationRequest;
    }

    public TimeSlotEntity getTimeSlot () {
        return timeSlot;
    }

    public void setTimeSlot ( TimeSlotEntity timeSlot ) {
        this.timeSlot = timeSlot;
    }
}
