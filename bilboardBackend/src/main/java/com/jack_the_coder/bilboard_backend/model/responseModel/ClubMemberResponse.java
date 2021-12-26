package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class ClubMemberResponse {
    private long id;
    private int attendedEventCount;
    private int gePoint;
    private UserResponse user;
    private BasicClubResponse club;

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
     * get attended event count gives number of event member attend
     * @return attendedEventCount is an integer
     */
    public int getAttendedEventCount () {
        return attendedEventCount;
    }

    /**
     * set attended event count
     * @param attendedEventCount is an integer parameter
     */
    public void setAttendedEventCount ( int attendedEventCount ) {
        this.attendedEventCount = attendedEventCount;
    }

    /**
     * get ge point method
     * @return gePoint is an integer
     */
    public int getGePoint () {
        return gePoint;
    }

    /**
     * set ge point method
     * @param gePoint is an integer parameter
     */
    public void setGePoint ( int gePoint ) {
        this.gePoint = gePoint;
    }

    /**
     * get user method
     * @return UserResponse
     */
    public UserResponse getUser () {
        return user;
    }

    /**
     * set user method
     * @param user is a UserResponse instance
     */
    public void setUser ( UserResponse user ) {
        this.user = user;
    }

    /**
     * get club method
     * @return BasicClubResponse
     */
    public BasicClubResponse getClub () {
        return club;
    }

    /**
     * set club method
     * @param club is a BasicClubResponse instance
     */
    public void setClub ( BasicClubResponse club ) {
        this.club = club;
    }
}
