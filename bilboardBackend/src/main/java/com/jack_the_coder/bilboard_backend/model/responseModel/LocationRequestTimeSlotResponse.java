package com.jack_the_coder.bilboard_backend.model.responseModel;


public class LocationRequestTimeSlotResponse {
    private long id;
    private TimeSlotResponse timeSlot;

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
     * Get timeSlot method
     * @return TimeSlotResponse
     */
    public TimeSlotResponse getTimeSlot () {
        return timeSlot;
    }

    /**
     * Set timeSlot method
     * @param timeSlot is TimeSlotResponse
     */
    public void setTimeSlot ( TimeSlotResponse timeSlot ) {
        this.timeSlot = timeSlot;
    }
}
