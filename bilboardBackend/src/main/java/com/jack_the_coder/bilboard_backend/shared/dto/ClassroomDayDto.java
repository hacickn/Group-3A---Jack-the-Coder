package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClassroomEntity;
import com.jack_the_coder.bilboard_backend.io.entity.TimeSlotEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the classroomdays
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class ClassroomDayDto implements Serializable {

    private static final long serialVersionUID = -4701462319296781115L;

    private long id;
    private Date dayDate;
    private List<TimeSlotEntity> timeSlots;
    private ClassroomEntity classroom;

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
     * @return TimeSlotEntity list
     */
    public List<TimeSlotEntity> getTimeSlots () {
        return timeSlots;
    }

    /**
     * Set time slots method
     * @param timeSlots is TimeSlotEntity list
     */
    public void setTimeSlots ( List<TimeSlotEntity> timeSlots ) {
        this.timeSlots = timeSlots;
    }

    /**
     * Get classroom method
     * @return ClassroomEntity
     */
    public ClassroomEntity getClassroom () {
        return classroom;
    }

    /**
     * Set classroom method
     * @param classroom is ClassroomEntity
     */
    public void setClassroom ( ClassroomEntity classroom ) {
        this.classroom = classroom;
    }
}
