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

    public List<TimeSlotEntity> getTimeSlots () {
        return timeSlots;
    }

    public void setTimeSlots ( List<TimeSlotEntity> timeSlots ) {
        this.timeSlots = timeSlots;
    }

    public ClassroomEntity getClassroom () {
        return classroom;
    }

    public void setClassroom ( ClassroomEntity classroom ) {
        this.classroom = classroom;
    }
}
