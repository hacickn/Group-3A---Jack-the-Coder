package com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class BasicEventParticipantResponse {

    private long id;
    private Boolean isAttended;
    private BasicUserResponse user;
    private Boolean pointGiven;
    private int point;

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
     * Get attended method
     * @return Boolean
     */
    public Boolean getAttended () {
        return isAttended;
    }

    /**
     * Set attended method
     * @param attended is Boolean
     */
    public void setAttended ( Boolean attended ) {
        isAttended = attended;
    }

    /**
     * Get user method
     * @return BasicUserResponse instance
     */
    public BasicUserResponse getUser () {
        return user;
    }

    /**
     * Set user method
     * @param user is a BasicUserResponse instance
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
     * @param point is an int parameter
     */
    public void setPoint ( int point ) {
        this.point = point;
    }

    /**
     * Get point given
     * @return boolean
     */
    public Boolean getPointGiven () {
        return pointGiven;
    }

    /**
     * set point given
     * @param pointGiven is a boolean
     */
    public void setPointGiven ( Boolean pointGiven ) {
        this.pointGiven = pointGiven;
    }
}
