package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the club sponsorship in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 11.11.2021
 */
@Entity( name = "club_sponsorships" )
public class ClubSponsorshipEntity implements Serializable {

    private static final long serialVersionUID = -1993543896577785356L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "name", length = 45, nullable = false )
    private String name;

    @Column( name = "photo", length = 45 )
    private String photo;

    @Column( name = "amount" )
    private int amount;

    @Column( name = "type", length = 45 )
    private String type;

    @ManyToOne( targetEntity = ClubEntity.class )
    @JoinColumn( name = "club" )
    private ClubEntity club;


}
