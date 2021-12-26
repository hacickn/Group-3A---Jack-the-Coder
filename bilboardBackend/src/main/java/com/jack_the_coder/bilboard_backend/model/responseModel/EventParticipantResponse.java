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
     * Get isAttended method
     * @return Boolean
     */
    public Boolean getAttended () {
        return isAttended;
    }

    /**
     * Set isAttended method
     * @param attended is Boolean
     */
    public void setAttended ( Boolean attended ) {
        isAttended = attended;
    }

    /**
     * Get user method
     * @return BasicUserResponse
     */
    public BasicUserResponse getUser () {
        return user;
    }

    /**
     * Set user method
     * @param user is BasicUserResponse
     */
    public void setUser ( BasicUserResponse user ) {
        this.user = user;
    }

    /**
     * Get point method
     * @return int
     */
    public int getPoint () {
        return point;
    }

    /**
     * Set point method
     * @param point is int
     */
    public void setPoint ( int point ) {
        this.point = point;
    }

    /**
     * Get event method
     * @return BasicEventResponse
     */
    public BasicEventResponse getEvent () {
        return event;
    }

    /**
     * Set event method
     * @param event is BasicEventResponse
     */
    public void setEvent ( BasicEventResponse event ) {
        this.event = event;
    }

    /**
     * Get pointGiven method
     * @return Boolean
     */
    public Boolean getPointGiven () {
        return pointGiven;
    }

    /**
     * Set pointGiven method
     * @param pointGiven is Boolean
     */
    public void setPointGiven ( Boolean pointGiven ) {
        this.pointGiven = pointGiven;
    }
}
