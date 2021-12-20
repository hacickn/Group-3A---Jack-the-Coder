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

    public BasicEventResponse getEvent () {
        return event;
    }

    public void setEvent ( BasicEventResponse event ) {
        this.event = event;
    }

    public List<LocationRequestTimeSlotResponse> getLocationRequestTimeSlots () {
        return locationRequestTimeSlots;
    }

    public void setLocationRequestTimeSlots (
            List<LocationRequestTimeSlotResponse> locationRequestTimeSlots ) {
        this.locationRequestTimeSlots = locationRequestTimeSlots;
    }
}
