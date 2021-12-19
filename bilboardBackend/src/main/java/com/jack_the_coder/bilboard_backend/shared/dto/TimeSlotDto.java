package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClassroomDayEntity;
import com.jack_the_coder.bilboard_backend.io.entity.LocationRequestTimeSlotEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the time slots
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class TimeSlotDto implements Serializable {

    private static final long serialVersionUID = -7004071151911053223L;

    private long id;
    private Date startTime;
    private Date endTime;
    private ClassroomDayEntity classroomDay;
    private List<LocationRequestTimeSlotEntity> locationRequestTimeSlots;

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

    public ClassroomDayEntity getClassroomDay () {
        return classroomDay;
    }

    public void setClassroomDay ( ClassroomDayEntity classroomDay ) {
        this.classroomDay = classroomDay;
    }

    public List<LocationRequestTimeSlotEntity> getLocationRequestTimeSlots () {
        return locationRequestTimeSlots;
    }

    public void setLocationRequestTimeSlots (
            List<LocationRequestTimeSlotEntity> locationRequestTimeSlots ) {
        this.locationRequestTimeSlots = locationRequestTimeSlots;
    }
}
