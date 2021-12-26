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

    /**
     * Get id method
     * @return the id
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id the id to set
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Get startTime method
     * @return Date
     */
    public Date getStartTime () {
        return startTime;
    }
    
    /**
     * Set startTime method
     * @param startTime is a Date parameter
     */
    public void setStartTime ( Date startTime ) {
        this.startTime = startTime;
    }

    /**
     * Get endTime method
     * @return Date
     */
    public Date getEndTime () {
        return endTime;
    }

    /**
     * Set endTime method
     * @param endTime is a Date parameter
     */
    public void setEndTime ( Date endTime ) {
        this.endTime = endTime;
    }

    /**
     * Get classroomDay method
     * @return ClassroomDayEntity
     */
    public ClassroomDayEntity getClassroomDay () {
        return classroomDay;
    }

    /**
     * Set classroomDay method
     * @param classroomDay is a ClassroomDayEntity parameter
     */
    public void setClassroomDay ( ClassroomDayEntity classroomDay ) {
        this.classroomDay = classroomDay;
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
