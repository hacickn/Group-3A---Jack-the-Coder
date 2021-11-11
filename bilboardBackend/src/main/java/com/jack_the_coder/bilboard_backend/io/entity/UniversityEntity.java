package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This class is base structure of the universities table in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 09.11.2021
 */
@Entity( name = "universities" )
public class UniversityEntity implements Serializable {

    private static final long serialVersionUID = 1615442836719692232L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "name", length = 100, nullable = false )
    private String name;

    // todo one-to-many => buildings,

    @OneToMany( targetEntity = UserEntity.class, mappedBy = "university" )
    private List<UserEntity> users;

    @OneToMany( targetEntity = ClubEntity.class, mappedBy = "university" )
    private List<ClubEntity> clubs;
}
