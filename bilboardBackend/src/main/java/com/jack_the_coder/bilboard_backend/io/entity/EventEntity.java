package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the event table in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 09.11.2021
 */
@Entity( name = "events" )
public class EventEntity implements Serializable {

    private static final long serialVersionUID = -7804457299300092894L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "restriction_for_member" )
    private Boolean restrictionForMember;

    @Column( name = "title", length = 45, nullable = false )
    private String title;

    @Column( name = "description", length = 400, nullable = false )
    private String description;

    @Column( name = "date", nullable = false )
    private Date date;

    @Column( name = "duration", length = 200 )
    private String duration;

    @Column( name = "location", length = 200 )
    private String location;

    @Column( name = "is_online", nullable = false )
    private Boolean isOnline;

    @Column( name = "max_participation_count", nullable = false )
    private int maxParticipationCount;

    @Column( name = "event_photo", length = 45 )
    private String eventPhoto;

    @Column( name = "event_code", length = 45 )
    private String eventCode;

    @Column( name = "is_visible" )
    private Boolean isVisible;

    @Column( name = "get_point" )
    private int getPoint;

    @Column( name = "event_code_expire" )
    private Date eventCodeExpire;

    @OneToMany( targetEntity = EventPointEntity.class, mappedBy = "event" )
    private List<EventPointEntity> eventPoints;

    // todo one-to-one => locationrequeststatus
    // todo many-to-one => clubs


}
