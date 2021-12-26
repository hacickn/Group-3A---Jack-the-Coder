package com.jack_the_coder.bilboard_backend.model.responseModel;


import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicEventParticipantResponse;

import java.util.Date;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class EventResponse {

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
    private BasicClubResponse club;
    private List<EventQuestionResponse> eventQuestions;
    private List<BasicEventParticipantResponse> eventParticipants;
    private List<LocationRequestResponse> locationRequests;

    /**
     * Get id method
     * @return long
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id is an long parameter
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
     * @param restrictionForMember is Boolean
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
     * @param title is String
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
     * @param description is String
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
     * @param date is Date
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
     * @param duration is String
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
     * @param location is String
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
     * @param isOnline is Boolean
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
     * @param maxParticipationCount is int
     */
    public void setMaxParticipationCount ( int maxParticipationCount ) {
        this.maxParticipationCount = maxParticipationCount;
    }

    /**
     * Get club method
     * @return BasicClubResponse
     */
    public BasicClubResponse getClub () {
        return club;
    }

    /**
     * Set club method
     * @param club is BasicClubResponse
     */
    public void setClub ( BasicClubResponse club ) {
        this.club = club;
    }

    /**
     * Get event photo method
     * @return String
     */
    public String getEventPhoto () {
        return eventPhoto;
    }

    /**
     * Set event photo method
     * @param eventPhoto is String
     */
    public void setEventPhoto ( String eventPhoto ) {
        this.eventPhoto = eventPhoto;
    }

    /**
     * Get event code method
     * @return String
     */
    public String getEventCode () {
        return eventCode;
    }

    /**
     * Set event code method
     * @param eventCode is String
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
     * @param isVisible is Boolean
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
     * @param gePoint is int
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
     * @param eventCodeExpire is Date
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
     * @param averageRate is int
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
     * @param rateCount is int
     */
    public void setRateCount ( int rateCount ) {
        this.rateCount = rateCount;
    }

    /**
     * Get eventQuestions method
     * @return List<EventQuestionResponse>
     */
    public List<EventQuestionResponse> getEventQuestions () {
        return eventQuestions;
    }

    /**
     * Set eventQuestions method
     * @param eventQuestions is List<EventQuestionResponse>
     */
    public void setEventQuestions (
            List<EventQuestionResponse> eventQuestions ) {
        this.eventQuestions = eventQuestions;
    }

    /**
     * Get eventParticipants method
     * @return List<BasicEventParticipantResponse>
     */
    public List<BasicEventParticipantResponse> getEventParticipants () {
        return eventParticipants;
    }

    /**
     * Set eventParticipants method
     * @param eventParticipants is List<BasicEventParticipantResponse>
     */
    public void setEventParticipants (
            List<BasicEventParticipantResponse> eventParticipants ) {
        this.eventParticipants = eventParticipants;
    }

    /**
     * Get locationRequests method
     * @return List<LocationRequestResponse>
     */
    public List<LocationRequestResponse> getLocationRequests () {
        return locationRequests;
    }

    /**
     * Set locationRequests method
     * @param locationRequests is List<LocationRequestResponse>
     */
    public void setLocationRequests (
            List<LocationRequestResponse> locationRequests ) {
        this.locationRequests = locationRequests;
    }
}
