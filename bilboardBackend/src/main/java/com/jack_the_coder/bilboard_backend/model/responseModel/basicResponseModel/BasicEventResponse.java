package com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.EventQuestionResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.LocationRequestResponse;

import java.util.Date;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class BasicEventResponse {
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
    private List<BasicEventParticipantResponse> eventParticipants;
    private List<BasicEventQuestionResponse> eventQuestions;

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
     * get event question answers method
     * @return eventQuestionAnswers is EventQuestionAnswerEntity list
     */
    public int getGePoint () {
        return gePoint;
    }

    /**
     * set event question answers method
     * @param gePoint is EventQuestionAnswerEntity list
     */
    public void setGePoint ( int gePoint ) {
        this.gePoint = gePoint;
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
     * get event question answers method
     * @return eventQuestionAnswers is EventQuestionAnswerEntity list
     */
    public int getAverageRate () {
        return averageRate;
    }

    /**
     * set event question answers method
     * @param averageRate is EventQuestionAnswerEntity list
     */
    public void setAverageRate ( int averageRate ) {
        this.averageRate = averageRate;
    }

    /**
     * get event question answers method
     * @return eventQuestionAnswers is EventQuestionAnswerEntity list
     */
    public int getRateCount () {
        return rateCount;
    }

    /**
     * set event question answers method
     * @param rateCount is EventQuestionAnswerEntity list
     */
    public void setRateCount ( int rateCount ) {
        this.rateCount = rateCount;
    }

    /**
     * get club method
     * @return club is BasicClubResponse instance
     */
    public BasicClubResponse getClub () {
        return club;
    }

    /**
     * set club method
     * @param club is BasicClubResponse instance
     */
    public void setClub ( BasicClubResponse club ) {
        this.club = club;
    }

    /**
     * get event participants method
     * @return eventParticipants is BasicEventParticipantResponse list
     */
    public List<BasicEventParticipantResponse> getEventParticipants () {
        return eventParticipants;
    }

    /**
     * set event participants method
     * @param eventParticipants is BasicEventParticipantResponse instance
     */
    public void setEventParticipants (
            List<BasicEventParticipantResponse> eventParticipants ) {
        this.eventParticipants = eventParticipants;
    }

    /**
     * get event questions method
     * @return eventQuestions is BasicEventQuestionResponse list
     */
    public List<BasicEventQuestionResponse> getEventQuestions () {
        return eventQuestions;
    }

    /**
     * set event questions method
     * @param eventQuestions is BasicEventQuestionResponse list
     */
    public void setEventQuestions (
            List<BasicEventQuestionResponse> eventQuestions ) {
        this.eventQuestions = eventQuestions;
    }
}
