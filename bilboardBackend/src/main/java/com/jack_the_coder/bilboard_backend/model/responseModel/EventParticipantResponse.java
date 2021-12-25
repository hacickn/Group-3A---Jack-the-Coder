package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicEventResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;

public class EventParticipantResponse {

    private long id;
    private Boolean isAttended;
    private BasicUserResponse user;
    private int point;
    private Boolean pointGiven;
    private BasicEventResponse event;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public Boolean getAttended () {
        return isAttended;
    }

    public void setAttended ( Boolean attended ) {
        isAttended = attended;
    }

    public BasicUserResponse getUser () {
        return user;
    }

    public void setUser ( BasicUserResponse user ) {
        this.user = user;
    }

    public int getPoint () {
        return point;
    }

    public void setPoint ( int point ) {
        this.point = point;
    }

    public BasicEventResponse getEvent () {
        return event;
    }

    public void setEvent ( BasicEventResponse event ) {
        this.event = event;
    }

    public Boolean getPointGiven () {
        return pointGiven;
    }

    public void setPointGiven ( Boolean pointGiven ) {
        this.pointGiven = pointGiven;
    }
}
