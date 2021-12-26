package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicEventResponse;

import java.util.List;

public class LocationRequestResponse {
    private long id;
    private Boolean answered;
    private Boolean confirmed;
    private int neededNumberOfSpaces;
    private BasicEventResponse event;
    private List<LocationRequestTimeSlotResponse> locationRequestTimeSlots;


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
     * Get answered method
     * @return Boolean
     */
    public Boolean getAnswered () {
        return answered;
    }

    /**
     * Set answered method
     * @param answered is Boolean
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
     * @param confirmed is Boolean
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
     * @return BasicEventResponse
     */
    public BasicEventResponse getEvent () {
        return event;
    }

    /**
     * Set event method
     * @param event is BasicEventResponse
     */
    public void setEvent ( BasicEventResponse event ) {
        this.event = event;
    }

    /**
     * Get locationRequestTimeSlots method
     * @return List<LocationRequestTimeSlotResponse>
     */
    public List<LocationRequestTimeSlotResponse> getLocationRequestTimeSlots () {
        return locationRequestTimeSlots;
    }

    /**
     * Set locationRequestTimeSlots method
     * @param locationRequestTimeSlots is List<LocationRequestTimeSlotResponse>
     */
    public void setLocationRequestTimeSlots (
            List<LocationRequestTimeSlotResponse> locationRequestTimeSlots ) {
        this.locationRequestTimeSlots = locationRequestTimeSlots;
    }
}
