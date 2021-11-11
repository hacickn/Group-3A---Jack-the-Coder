package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın
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

    private Date dayDate;

    @OneToMany( targetEntity = TimeSlotEntity.class, mappedBy = "classroomDay" )
    private List<TimeSlotEntity> timeSlots;

    // todo classroom relations
}
