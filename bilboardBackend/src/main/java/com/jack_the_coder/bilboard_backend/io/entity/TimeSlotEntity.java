package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the time_slots table in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 09.11.2021
 */
@Entity( name = "time_slots" )
public class TimeSlotEntity implements Serializable {

    private static final long serialVersionUID = -6495963028713734532L;

    @GeneratedValue
    @Id
    @Column(name = "id")
    private long id;

    @Column( name = "start_time", nullable = false )
    private Date startTime;

    @Column( name = "end_time", nullable = false )
    private Date endTime;
}

    // todo many-to-one => classroomday
