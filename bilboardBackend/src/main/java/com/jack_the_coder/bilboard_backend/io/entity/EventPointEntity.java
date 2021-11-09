package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the event_points table in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 09.11.2021
 */

@Entity( name = "event_points" )
public class EventPointEntity implements Serializable {

    private static final long serialVersionUID = 8318276210650090252L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "point" )
    private int point;

    @ManyToOne( targetEntity = UserEntity.class )
    @JoinColumn( name = "user ")
    private UserEntity user;

    // todo ManyToOne => Event


}
