package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the location_request_time_slots table in database
 * @implNote DONE
 * @since 09.11.2021
 */
@Entity( name = "location_request_time_slots" )
public class LocationRequestTimeSlotEntity implements Serializable {

    private static final long serialVersionUID = 6585212343588545565L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @ManyToOne( targetEntity = LocationRequestEntity.class )
    @JoinColumn( name = "location_request" )
    private LocationRequestEntity locationRequest;

    @ManyToOne( targetEntity = TimeSlotEntity.class )
    @JoinColumn( name = "time_slot" )
    private TimeSlotEntity timeSlot;

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
     * get location request method
     * @return locationRequest is a LocationRequestEntity
     */
    public LocationRequestEntity getLocationRequest () {
        return locationRequest;
    }

    /**
     * set location request method
     * @param locationRequest is a LocationRequestEntity
     */
    public void setLocationRequest ( LocationRequestEntity locationRequest ) {
        this.locationRequest = locationRequest;
    }

    /**
     * get time slots method
     * @return timeSlot is a TimeSlotEntity
     */
    public TimeSlotEntity getTimeSlots () {
        return timeSlot;
    }

    /**
     * set time slots method
     * @param timeSlot is a TimeSlotEntity
     */
    public void setTimeSlots ( TimeSlotEntity timeSlot ) {
        this.timeSlot = timeSlot;
    }
}
