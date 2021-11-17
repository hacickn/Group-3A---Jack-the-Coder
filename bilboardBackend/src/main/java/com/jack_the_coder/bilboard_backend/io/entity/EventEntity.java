package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the events table in database
 * @implNote DONE
 * @since 09.11.2021
 */
@Entity( name = "events" )
public class EventEntity implements Serializable {

    private static final long serialVersionUID = -3291404561366889311L;

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

    @Column( name = "point" )
    private int point;

    @Column( name = "event_code_expire" )
    private Date eventCodeExpire;

    @OneToMany( targetEntity = EventPointEntity.class, mappedBy = "event" )
    private List<EventPointEntity> eventPoints;

    @ManyToOne( targetEntity = ClubEntity.class )
    @JoinColumn( name = "club" )
    private ClubEntity club;

    @OneToMany( targetEntity = EventQuestionEntity.class, mappedBy = "event" )
    private List<EventQuestionEntity> eventQuestions;

    @OneToMany( targetEntity = EventParticipantEntity.class, mappedBy = "event" )
    private List<EventParticipantEntity> eventParticipants;

    @OneToMany( targetEntity = LocationRequestEntity.class, mappedBy = "event" )
    private List<LocationRequestEntity> locationRequests;

    /**
     * get id method
     * @return id is a long
     */
    public long getId () {
        return id;
    }

    /**
     * set id method
     * @param id is a long parameter
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * get restriction for member method
     * @return restrictionForMember is Boolean
     */
    public Boolean getRestrictionForMember () {
        return restrictionForMember;
    }

    /**
     * set restriction for member method
     * @param restrictionForMember is Boolean
     */
    public void setRestrictionForMember ( Boolean restrictionForMember ) {
        this.restrictionForMember = restrictionForMember;
    }

    /**
     * get title method
     * @return title is String
     */
    public String getTitle () {
        return title;
    }

    /**
     * set title method
     * @param title is String
     */
    public void setTitle ( String title ) {
        this.title = title;
    }

    /**
     * get description method
     * @return description is String
     */
    public String getDescription () {
        return description;
    }

    /**
     * set description method
     * @param description is String
     */
    public void setDescription ( String description ) {
        this.description = description;
    }

    /**
     * get date method
     * @return date is Date
     */
    public Date getDate () {
        return date;
    }

    /**
     * set date method
     * @param date is Date
     */
    public void setDate ( Date date ) {
        this.date = date;
    }

    /**
     * get duration method
     * @return duration is String
     */
    public String getDuration () {
        return duration;
    }

    /**
     * set duration method
     * @param duration is String
     */
    public void setDuration ( String duration ) {
        this.duration = duration;
    }

    /**
     * get location method
     * @return location is String
     */
    public String getLocation () {
        return location;
    }

    /**
     * set location method
     * @param location is String
     */
    public void setLocation ( String location ) {
        this.location = location;
    }

    /**
     * get is online method
     * @return isOnline is Boolean
     */
    public Boolean getOnline () {
        return isOnline;
    }

    /**
     * set online method
     * @param online is Boolean
     */
    public void setOnline ( Boolean online ) {
        isOnline = online;
    }

    /**
     * get max participation count method
     * @return maxParticipationCount is int
     */
    public int getMaxParticipationCount () {
        return maxParticipationCount;
    }

    /**
     * set max participation count method
     * @param maxParticipationCount is int
     */
    public void setMaxParticipationCount ( int maxParticipationCount ) {
        this.maxParticipationCount = maxParticipationCount;
    }

    /**
     * get event photo method
     * @return eventPhoto is String
     */
    public String getEventPhoto () {
        return eventPhoto;
    }

    /**
     * set event photo method
     * @param eventPhoto is String
     */
    public void setEventPhoto ( String eventPhoto ) {
        this.eventPhoto = eventPhoto;
    }

    /**
     * get event code method
     * @return eventCode is String
     */
    public String getEventCode () {
        return eventCode;
    }

    /**
     * set event code method
     * @param eventCode is String
     */
    public void setEventCode ( String eventCode ) {
        this.eventCode = eventCode;
    }

    /**
     * get is visible method
     * @return isVisible is Boolean
     */
    public Boolean getVisible () {
        return isVisible;
    }

    /**
     * set visible method
     * @param visible is Boolean
     */
    public void setVisible ( Boolean visible ) {
        isVisible = visible;
    }

    /**
     * get point method
     * @return point is int
     */
    public int getPoint () {
        return point;
    }

    /**
     * set point method
     * @param point is int
     */
    public void setPoint ( int point ) {
        this.point = point;
    }

    /**
     * get event code expire method
     * @return eventCodeExpire is Date
     */
    public Date getEventCodeExpire () {
        return eventCodeExpire;
    }

    /**
     * set event code expire method
     * @param eventCodeExpire is Date
     */
    public void setEventCodeExpire ( Date eventCodeExpire ) {
        this.eventCodeExpire = eventCodeExpire;
    }

    /**
     * get event points method
     * @return eventPoints is EventPointEntity list
     */
    public List<EventPointEntity> getEventPoints () {
        return eventPoints;
    }

    /**
     * set event points method
     * @param eventPoints is EventPointEntity list
     */
    public void setEventPoints ( List<EventPointEntity> eventPoints ) {
        this.eventPoints = eventPoints;
    }

    /**
     * get club method
     * @return club is ClubEntity
     */
    public ClubEntity getClub () {
        return club;
    }

    /**
     * set club method
     * @param club is ClubEntity
     */
    public void setClub ( ClubEntity club ) {
        this.club = club;
    }

    /**
     * get event question method
     * @return eventQuestions is EventQuestionEntity list
     */
    public List<EventQuestionEntity> getEventQuestions () {
        return eventQuestions;
    }

    /**
     * set event question method
     * @param eventQuestions is EventQuestionEntity list
     */
    public void setEventQuestions (
            List<EventQuestionEntity> eventQuestions ) {
        this.eventQuestions = eventQuestions;
    }

    /**
     * get event participants method
     * @return eventParticipants is EventParticipantEntity list
     */
    public List<EventParticipantEntity> getEventParticipants () {
        return eventParticipants;
    }

    /**
     * set event participants method
     * @param eventParticipants is EventParticipantEntity list
     */
    public void setEventParticipants (
            List<EventParticipantEntity> eventParticipants ) {
        this.eventParticipants = eventParticipants;
    }

    /**
     * get location request method
     * @return locationRequests is LocationRequestEntity list
     */
    public List<LocationRequestEntity> getLocationRequests () {
        return locationRequests;
    }

    /**
     * set location request method
     * @param locationRequests is LocationRequestEntity
     */
    public void setLocationRequests (
            List<LocationRequestEntity> locationRequests ) {
        this.locationRequests = locationRequests;
    }
}
