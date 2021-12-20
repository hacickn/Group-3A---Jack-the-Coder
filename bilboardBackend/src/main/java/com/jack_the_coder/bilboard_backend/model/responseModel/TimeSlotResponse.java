package com.jack_the_coder.bilboard_backend.model.responseModel;

import javax.persistence.Column;
import java.util.Date;

public class TimeSlotResponse {
    private long id;
    private Date startTime;
    private Date endTime;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public Date getStartTime () {
        return startTime;
    }

    public void setStartTime ( Date startTime ) {
        this.startTime = startTime;
    }

    public Date getEndTime () {
        return endTime;
    }

    public void setEndTime ( Date endTime ) {
        this.endTime = endTime;
    }
}
