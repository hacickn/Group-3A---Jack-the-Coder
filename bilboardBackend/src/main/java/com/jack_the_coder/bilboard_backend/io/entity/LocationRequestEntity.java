package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the location requests table in database
 * @implNote After completing relations, getters and setters should be implemented
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
}
