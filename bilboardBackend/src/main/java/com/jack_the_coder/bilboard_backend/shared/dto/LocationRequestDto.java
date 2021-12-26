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

    /**
     * Get id method
     * @return long
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id is a long parameter
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Get answered method
     * @return Boolean
     */
    public Boolean getAnswered () {
        return answered;
    }

    /**
     * Set answered method
     * @param answered is a Boolean parameter
     */
    public void setAnswered ( Boolean answered ) {
        this.answered = answered;
    }

    /**
     * Get confirmed method
     * @return Boolean
     */
    public Boolean getConfirmed () {
        return confirmed;
    }

    /**
     * Set confirmed method
     * @param confirmed is a Boolean parameter
     */
    public void setConfirmed ( Boolean confirmed ) {
        this.confirmed = confirmed;
    }

    /**
     * Get neededNumberOfSpaces method
     * @return int
     */
    public int getNeededNumberOfSpaces () {
        return neededNumberOfSpaces;
    }

    /**
     * Set neededNumberOfSpaces method
     * @param neededNumberOfSpaces is an int parameter
     */
    public void setNeededNumberOfSpaces ( int neededNumberOfSpaces ) {
        this.neededNumberOfSpaces = neededNumberOfSpaces;
    }

    /**
     * Get event method
     * @return EventEntity
     */
    public EventEntity getEvent () {
        return event;
    }

    /**
     * Set event method
     * @param event is an EventEntity parameter
     */
    public void setEvent ( EventEntity event ) {
        this.event = event;
    }

    /**
     * Get locationRequestTimeSlots method
     * @return List<LocationRequestTimeSlotEntity>
     */
    public List<LocationRequestTimeSlotEntity> getLocationRequestTimeSlots () {
        return locationRequestTimeSlots;
    }

    /**
     * Set locationRequestTimeSlots method
     * @param locationRequestTimeSlots is a List<LocationRequestTimeSlotEntity> parameter
     */
    public void setLocationRequestTimeSlots (
            List<LocationRequestTimeSlotEntity> locationRequestTimeSlots ) {
        this.locationRequestTimeSlots = locationRequestTimeSlots;
    }
}
