package com.jack_the_coder.bilboard_backend.model.responseModel;


public class LocationRequestTimeSlotResponse {
    private long id;
    private TimeSlotResponse timeSlot;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public TimeSlotResponse getTimeSlot () {
        return timeSlot;
    }

    public void setTimeSlot ( TimeSlotResponse timeSlot ) {
        this.timeSlot = timeSlot;
    }
}
