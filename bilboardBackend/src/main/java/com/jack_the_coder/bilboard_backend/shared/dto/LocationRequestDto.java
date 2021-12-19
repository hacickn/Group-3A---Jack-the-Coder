package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.EventEntity;
import com.jack_the_coder.bilboard_backend.io.entity.LocationRequestTimeSlotEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the location requests
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class LocationRequestDto implements Serializable {

    private static final long serialVersionUID = -7004177166911053223L;

    private long id;
    private Boolean answered;
    private Boolean confirmed;
    private int neededNumberOfSpaces;
    private EventEntity event;
    private List<LocationRequestTimeSlotEntity> locationRequestTimeSlots;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public Boolean getAnswered () {
        return answered;
    }

    public void setAnswered ( Boolean answered ) {
        this.answered = answered;
    }

    public Boolean getConfirmed () {
        return confirmed;
    }

    public void setConfirmed ( Boolean confirmed ) {
        this.confirmed = confirmed;
    }

    public int getNeededNumberOfSpaces () {
        return neededNumberOfSpaces;
    }

    public void setNeededNumberOfSpaces ( int neededNumberOfSpaces ) {
        this.neededNumberOfSpaces = neededNumberOfSpaces;
    }

    public EventEntity getEvent () {
        return event;
    }

    public void setEvent ( EventEntity event ) {
        this.event = event;
    }

    public List<LocationRequestTimeSlotEntity> getLocationRequestTimeSlots () {
        return locationRequestTimeSlots;
    }

    public void setLocationRequestTimeSlots (
            List<LocationRequestTimeSlotEntity> locationRequestTimeSlots ) {
        this.locationRequestTimeSlots = locationRequestTimeSlots;
    }
}
