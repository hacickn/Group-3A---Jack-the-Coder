package com.jack_the_coder.bilboard_backend.model.responseModel;

import java.util.Date;
import java.util.List;

public class ClassroomDayResponse {

    private long id;
    private Date dayDate;
    private List<TimeSlotResponse> timeSlots;

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
     * Get day date method
     * @return Date
     */
    public Date getDayDate () {
        return dayDate;
    }

    /**
     * Set day date method
     * @param dayDate is Date
     */
    public void setDayDate ( Date dayDate ) {
        this.dayDate = dayDate;
    }

    /**
     * Get time slots method
     * @return TimeSlotResponse
     */
    public List<TimeSlotResponse> getTimeSlots () {
        return timeSlots;
    }

    /**
     * Set time slots method
     * @param timeSlots is TimeSlotResponse
     */
    public void setTimeSlots (
            List<TimeSlotResponse> timeSlots ) {
        this.timeSlots = timeSlots;
    }
}
