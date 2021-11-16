package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the buildings in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 11.11.2021
 */
@Entity( name = "club_feedbacks" )
public class ClubFeedbackEntity implements Serializable {

    private static final long serialVersionUID = -3993542896569185356L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "content", length = 300, nullable = false )
    private String content;

    @Column( name = "date", nullable = false )
    private Date date;

    @ManyToOne( targetEntity = ClubEntity.class )
    @JoinColumn( name = "club" )
    private ClubEntity club;

    @ManyToOne( targetEntity = UserEntity.class )
    @JoinColumn( name = "user" )
    private UserEntity user;
}
