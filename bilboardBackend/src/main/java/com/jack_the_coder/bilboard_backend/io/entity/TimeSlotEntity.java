package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This class is base structure of the time_slots table in database
 * @implNote DONE
 * @since 09.11.2021
 */
@Entity( name = "time_slots" )
public class TimeSlotEntity implements Serializable {

    private static final long serialVersionUID = -7180893828872253189L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "start_time", nullable = false )
    private Date startTime;

    @Column( name = "end_time", nullable = false )
    private Date endTime;

    @ManyToOne( targetEntity = ClassroomDayEntity.class )
    @JoinColumn( name = "classroom_day" )
    private ClassroomDayEntity classroomDay;

    @OneToMany( targetEntity = LocationRequestTimeSlotEntity.class, mappedBy = "time_slot" )
    private List<LocationRequestTimeSlotEntity> locationRequestTimeSlots;

    /**
     * get id method
     * @return id is an long
     */
    public long getId () {
        return id;
    }

    /**
     * set id method
     * @param id long parameter
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * get start time method
     * @return startTime is an Date, refers to start time of the time slot
     */
    public Date getStartTime () {
        return startTime;
    }

    /**
     * set start time method
     * @param startTime is an Date, refers to start time of the time slot
     */
    public void setStartTime ( Date startTime ) {
        this.startTime = startTime;
    }

    /**
     * set end time method
     * @return endTime is an Date, refers to end time of the time slot
     */
    public Date getEndTime () {
        return endTime;
    }

    /**
     * set end time method
     * @param endTime is an Date, refers to end time of the time slot
     */
    public void setEndTime ( Date endTime ) {
        this.endTime = endTime;
    }

    /**
     * get classroom day method
     * @return classroomDay which this time slot instance belongs to
     */
    public ClassroomDayEntity getClassroomDay () {
        return classroomDay;
    }

    /**
     * set classroomDay method
     * @param classroomDay is an ClassroomDayEntity instance
     */
    public void setClassroomDay ( ClassroomDayEntity classroomDay ) {
        this.classroomDay = classroomDay;
    }

    /**
     * get location request time slots method
     * @return locationRequestTimeSlots which this time slot instance belongs to
     */
    public List<LocationRequestTimeSlotEntity> getLocationRequestTimeSlots () {
        return locationRequestTimeSlots;
    }

    /**
     * set location request time slots method
     * @param locationRequestTimeSlots is a LocationRequestTimeSlotEntity instance
     */
    public void setLocationRequestTimeSlots (
            List<LocationRequestTimeSlotEntity> locationRequestTimeSlots ) {
        this.locationRequestTimeSlots = locationRequestTimeSlots;
    }
}


