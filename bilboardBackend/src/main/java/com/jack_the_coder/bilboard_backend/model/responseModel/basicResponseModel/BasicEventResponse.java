package com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.EventQuestionResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.LocationRequestResponse;

import java.util.Date;
import java.util.List;

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


    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public Boolean getRestrictionForMember () {
        return restrictionForMember;
    }

    public void setRestrictionForMember ( Boolean restrictionForMember ) {
        this.restrictionForMember = restrictionForMember;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public Date getDate () {
        return date;
    }

    public void setDate ( Date date ) {
        this.date = date;
    }

    public String getDuration () {
        return duration;
    }

    public void setDuration ( String duration ) {
        this.duration = duration;
    }

    public String getLocation () {
        return location;
    }

    public void setLocation ( String location ) {
        this.location = location;
    }

    public Boolean getOnline () {
        return isOnline;
    }

    public void setOnline ( Boolean online ) {
        isOnline = online;
    }

    public int getMaxParticipationCount () {
        return maxParticipationCount;
    }

    public void setMaxParticipationCount ( int maxParticipationCount ) {
        this.maxParticipationCount = maxParticipationCount;
    }

    public String getEventPhoto () {
        return eventPhoto;
    }

    public void setEventPhoto ( String eventPhoto ) {
        this.eventPhoto = eventPhoto;
    }

    public String getEventCode () {
        return eventCode;
    }

    public void setEventCode ( String eventCode ) {
        this.eventCode = eventCode;
    }

    public Boolean getVisible () {
        return isVisible;
    }

    public void setVisible ( Boolean visible ) {
        isVisible = visible;
    }

    public int getGePoint () {
        return gePoint;
    }

    public void setGePoint ( int gePoint ) {
        this.gePoint = gePoint;
    }

    public Date getEventCodeExpire () {
        return eventCodeExpire;
    }

    public void setEventCodeExpire ( Date eventCodeExpire ) {
        this.eventCodeExpire = eventCodeExpire;
    }

    public int getAverageRate () {
        return averageRate;
    }

    public void setAverageRate ( int averageRate ) {
        this.averageRate = averageRate;
    }

    public int getRateCount () {
        return rateCount;
    }

    public void setRateCount ( int rateCount ) {
        this.rateCount = rateCount;
    }

    public BasicClubResponse getClub () {
        return club;
    }

    public void setClub ( BasicClubResponse club ) {
        this.club = club;
    }

    public List<BasicEventParticipantResponse> getEventParticipants () {
        return eventParticipants;
    }

    public void setEventParticipants (
            List<BasicEventParticipantResponse> eventParticipants ) {
        this.eventParticipants = eventParticipants;
    }

    public List<BasicEventQuestionResponse> getEventQuestions () {
        return eventQuestions;
    }

    public void setEventQuestions (
            List<BasicEventQuestionResponse> eventQuestions ) {
        this.eventQuestions = eventQuestions;
    }
}
