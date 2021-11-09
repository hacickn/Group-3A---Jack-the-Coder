package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Hacı Çakın
 * @since  09.11.2021
 * @apiNote This class is base structure of the universities table in database
 * @implNote After completing relations, getters and setters should be implemented
 */
@Entity( name = "universities" )
public class UniversityEntity implements Serializable {

    private static final long serialVersionUID = 7317275210550090252L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "name", length = 100, nullable = false )
    private String name;

    // todo one-to-many => buildings, users, clubs
}
