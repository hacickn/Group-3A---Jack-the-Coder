package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.EventParticipantEntity;
import com.jack_the_coder.bilboard_backend.io.entity.EventQuestionEntity;
import com.jack_the_coder.bilboard_backend.io.entity.LocationRequestEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın and Aslı Dinç
 * @apiNote This class is data transfer object of the events
 * @implNote DONE
 * @since 13.12.2021
 */
public class EventDto implements Serializable {

    private static final long serialVersionUID = -4701452319296781115L;

    private long id;
    private Boolean restrictionForMember;
    private String title;
    private String description;
    private Date date;
    private String duration;
    private String location;
    private Boolean isOnline;
    private int maxParticipationCount;
    private String eventPhoto;
    private String eventCode;
    private Boolean isVisible;
    private int gePoint;
    private Date eventCodeExpire;
    private int averageRate;
    private int rateCount;
    private ClubEntity club;
    private List<EventQuestionEntity> eventQuestions;
    private List<EventParticipantEntity> eventParticipants;
    private List<LocationRequestEntity> locationRequests;

    /**
     * Get id method
     * @return the id
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id is a long
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Get restrictionForMember method
     * @return Boolean
     */
    public Boolean getRestrictionForMember () {
        return restrictionForMember;
    }

    /**
     * Set restrictionForMember method
     * @param restrictionForMember is a Boolean
     */
    public void setRestrictionForMember ( Boolean restrictionForMember ) {
        this.restrictionForMember = restrictionForMember;
    }

    /**
     * Get title method
     * @return String
     */
    public String getTitle () {
        return title;
    }

    /**
     * Set title method
     * @param title is a String
     */
    public void setTitle ( String title ) {
        this.title = title;
    }

    /**
     * Get description method
     * @return String
     */
    public String getDescription () {
        return description;
    }

    /**
     * Set description method
     * @param description is a String
     */
    public void setDescription ( String description ) {
        this.description = description;
    }

    /**
     * Get date method
     * @return Date
     */
    public Date getDate () {
        return date;
    }

    /**
     * Set date method
     * @param date is a Date
     */
    public void setDate ( Date date ) {
        this.date = date;
    }

    /**
     * Get duration method
     * @return String
     */
    public String getDuration () {
        return duration;
    }

    /**
     * Set duration method
     * @param duration is a String
     */
    public void setDuration ( String duration ) {
        this.duration = duration;
    }

    /**
     * Get location method
     * @return String
     */
    public String getLocation () {
        return location;
    }

    /**
     * Set location method
     * @param location is a String
     */
    public void setLocation ( String location ) {
        this.location = location;
    }

    /**
     * Get isOnline method
     * @return Boolean
     */
    public Boolean getOnline () {
        return isOnline;
    }

    /**
     * Set isOnline method
     * @param isOnline is a Boolean
     */
    public void setOnline ( Boolean online ) {
        isOnline = online;
    }

    /**
     * Get maxParticipationCount method
     * @return int
     */
    public int getMaxParticipationCount () {
        return maxParticipationCount;
    }

    /**
     * Set maxParticipationCount method
     * @param maxParticipationCount is a int
     */
    public void setMaxParticipationCount ( int maxParticipationCount ) {
        this.maxParticipationCount = maxParticipationCount;
    }

    /**
     * Get eventPhoto method
     * @return String
     */
    public String getEventPhoto () {
        return eventPhoto;
    }

    /**
     * Set eventPhoto method
     * @param eventPhoto is a String
     */
    public void setEventPhoto ( String eventPhoto ) {
        this.eventPhoto = eventPhoto;
    }

    /**
     * Get eventCode method
     * @return String
     */
    public String getEventCode () {
        return eventCode;
    }

    /**
     * Set eventCode method
     * @param eventCode is a String
     */
    public void setEventCode ( String eventCode ) {
        this.eventCode = eventCode;
    }

    /**
     * Get isVisible method
     * @return Boolean
     */
    public Boolean getVisible () {
        return isVisible;
    }

    /**
     * Set isVisible method
     * @param isVisible is a Boolean
     */
    public void setVisible ( Boolean visible ) {
        isVisible = visible;
    }
    
    /**
     * Get gePoint method
     * @return int
     */
    public int getGePoint () {
        return gePoint;
    }

    /**
     * Set gePoint method
     * @param gePoint is a int
     */
    public void setGePoint ( int gePoint ) {
        this.gePoint = gePoint;
    }

    /**
     * Get eventCodeExpire method
     * @return Date
     */
    public Date getEventCodeExpire () {
        return eventCodeExpire;
    }

    /**
     * Set eventCodeExpire method
     * @param eventCodeExpire is a Date
     */
    public void setEventCodeExpire ( Date eventCodeExpire ) {
        this.eventCodeExpire = eventCodeExpire;
    }

    /**
     * Get averageRate method
     * @return int
     */
    public int getAverageRate () {
        return averageRate;
    }

    /**
     * Set averageRate method
     * @param averageRate is a int
     */
    public void setAverageRate ( int averageRate ) {
        this.averageRate = averageRate;
    }

    /**
     * Get rateCount method
     * @return int
     */
    public int getRateCount () {
        return rateCount;
    }

    /**
     * Set rateCount method
     * @param rateCount is a int
     */
    public void setRateCount ( int rateCount ) {
        this.rateCount = rateCount;
    }

    /**
     * Get club method
     * @return ClubEntity
     */
    public ClubEntity getClub () {
        return club;
    }

    /**
     * Set club method
     * @param club is a ClubEntity
     */
    public void setClub ( ClubEntity club ) {
        this.club = club;
    }

    /**
     * Get eventQuestions method
     * @return List<EventQuestionEntity>
     */
    public List<EventQuestionEntity> getEventQuestions () {
        return eventQuestions;
    }

    /**
     * Set eventQuestions method
     * @param eventQuestions is a List<EventQuestionEntity>
     */
    public void setEventQuestions (
            List<EventQuestionEntity> eventQuestions ) {
        this.eventQuestions = eventQuestions;
    }

    /**
     * Get eventParticipations method
     * @return List<EventParticipationEntity>
     */
    public List<EventParticipantEntity> getEventParticipants () {
        return eventParticipants;
    }

    /**
     * Set eventParticipations method
     * @param eventParticipations is a List<EventParticipationEntity>
     */
    public void setEventParticipants (
            List<EventParticipantEntity> eventParticipants ) {
        this.eventParticipants = eventParticipants;
    }

    /**
     * Get locationRequests method
     * @return List<LocationRequestEntity>
     */
    public List<LocationRequestEntity> getLocationRequests () {
        return locationRequests;
    }

    /**
     * Set locationRequests method
     * @param locationRequests is a List<LocationRequestEntity>
     */
    public void setLocationRequests (
            List<LocationRequestEntity> locationRequests ) {
        this.locationRequests = locationRequests;
    }
}
