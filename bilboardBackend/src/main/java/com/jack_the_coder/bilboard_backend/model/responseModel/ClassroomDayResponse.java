package com.jack_the_coder.bilboard_backend.model.responseModel;

import java.util.Date;
import java.util.List;

public class ClassroomDayResponse {

    private long id;
    private Date dayDate;
    private List<TimeSlotResponse> timeSlots;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public Date getDayDate () {
        return dayDate;
    }

    public void setDayDate ( Date dayDate ) {
        this.dayDate = dayDate;
    }

    public List<TimeSlotResponse> getTimeSlots () {
        return timeSlots;
    }

    public void setTimeSlots (
            List<TimeSlotResponse> timeSlots ) {
        this.timeSlots = timeSlots;
    }
}
