package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;

public class ClubBoardMemberResponse {

    private long id;
    private BasicUserResponse user;
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
     * get user method
     * @return BasicUserResponse
     */
    public BasicUserResponse getUser () {
        return user;
    }

    /**
     * set user method
     * @param user is a BasicUserResponse instance
     */
    public void setUser ( BasicUserResponse user ) {
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
