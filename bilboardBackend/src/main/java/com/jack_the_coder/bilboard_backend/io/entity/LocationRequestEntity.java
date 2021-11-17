package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the location_requests table in database
 * @implNote DONE
 * @since 09.11.2021
 */
@Entity( name = "location_requests" )
public class LocationRequestEntity implements Serializable {

    private static final long serialVersionUID = 8585111263588545565L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "answered" )
    private Boolean answered;

    @Column( name = "confirmed" )
    private Boolean confirmed;

    @Column( name = "needed_number_of_spaces" )
    private int neededNumberOfSpaces;

    @ManyToOne( targetEntity = EventEntity.class )
    @JoinColumn( name = "event" )
    private EventEntity event;

    @OneToMany( targetEntity = LocationRequestTimeSlotEntity.class, mappedBy = "location_request" )
    private List<LocationRequestTimeSlotEntity> locationRequestTimeSlots;

    /**
     * get id method
     * @return id is a long
     */
    public long getId () {
        return id;
    }

    /**
     * set id method
     * @param id is a long parameter
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * get answered method
     * @return answered is Boolean
     */
    public Boolean getAnswered () {
        return answered;
    }

    /**
     * set answered method
     * @param answered is Boolean
     */
    public void setAnswered ( Boolean answered ) {
        this.answered = answered;
    }

    /**
     * get confirmed method
     * @return confirmed is Boolean
     */
    public Boolean getConfirmed () {
        return confirmed;
    }

    /**
     * set confirmed method
     * @param confirmed is Boolean
     */
    public void setConfirmed ( Boolean confirmed ) {
        this.confirmed = confirmed;
    }

    /**
     * get needed number of spaces method
     * @return neededNumberOfSpaces is int
     */
    public int getNeededNumberOfSpaces () {
        return neededNumberOfSpaces;
    }

    /**
     * set needed number of spaces method
     * @param neededNumberOfSpaces is int
     */
    public void setNeededNumberOfSpaces ( int neededNumberOfSpaces ) {
        this.neededNumberOfSpaces = neededNumberOfSpaces;
    }

    /**
     * get event method
     * @return event is EventEntity
     */
    public EventEntity getEvent () {
        return event;
    }

    /**
     * set event method
     * @param event is EventEntity
     */
    public void setEvent ( EventEntity event ) {
        this.event = event;
    }

    /**
     * get location request time slots method
     * @return locationRequestTimeSlots is LocationRequestTimeSlotEntity list
     */
    public List<LocationRequestTimeSlotEntity> getLocationRequestTimeSlots () {
        return locationRequestTimeSlots;
    }

    /**
     * set location request time slots method
     * @param locationRequestTimeSlots is LocationRequestTimeSlotEntity list
     */
    public void setLocationRequestTimeSlots (
            List<LocationRequestTimeSlotEntity> locationRequestTimeSlots ) {
        this.locationRequestTimeSlots = locationRequestTimeSlots;
    }
}
