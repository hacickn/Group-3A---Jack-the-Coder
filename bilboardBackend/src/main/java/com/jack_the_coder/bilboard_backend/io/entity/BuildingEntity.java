package com.jack_the_coder.bilboard_backend.io.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the buildings in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 11.11.2021
 */
@Entity( name = "buildings" )
public class BuildingEntity implements Serializable {

    private static final long serialVersionUID = -3993541896569285225L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    private String name;

    @ManyToOne( targetEntity = UniversityEntity.class )
    @JoinColumn( name = "university" )
    private UniversityEntity university;

    // todo one-to-many classrooms

}
