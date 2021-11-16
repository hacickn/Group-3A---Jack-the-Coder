package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the classrooms in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 11.11.2021
 */
@Entity( name = "classrooms" )
public class ClassroomEntity {

    private static final long serialVersionUID = -7994542806569385225L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "name", length = 45, nullable = false )
    private String name;

    @ManyToOne( targetEntity = BuildingEntity.class )
    @JoinColumn( name = "building" )
    private BuildingEntity building;

    @OneToMany( targetEntity = ClassroomDayEntity.class, mappedBy = "classroom" )
    private List<ClassroomDayEntity> classroomDays;
}
