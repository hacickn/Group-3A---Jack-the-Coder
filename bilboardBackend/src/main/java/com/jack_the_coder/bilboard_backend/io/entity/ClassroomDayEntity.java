package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın and Aslı Dinç
 * @apiNote This class is base structure of the classroom days in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 11.11.2021
 */
@Entity( name = "classroom_days" )
public class ClassroomDayEntity implements Serializable {

    private static final long serialVersionUID = 415923675075092456L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "day_date", nullable = false )
    private Date dayDate;

    @OneToMany( targetEntity = TimeSlotEntity.class, mappedBy = "classroomDay" )
    private List<TimeSlotEntity> timeSlots;

    @ManyToOne( targetEntity = ClassroomEntity.class )
    @JoinColumn( name = "classroom" )
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
