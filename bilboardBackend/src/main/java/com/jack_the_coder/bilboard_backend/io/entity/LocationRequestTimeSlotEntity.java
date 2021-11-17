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


}
