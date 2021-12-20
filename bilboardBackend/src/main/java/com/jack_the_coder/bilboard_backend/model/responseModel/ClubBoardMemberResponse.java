package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;

public class ClubBoardMemberResponse {

    private long id;
    private BasicUserResponse user;
    private BasicClubResponse club;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public BasicUserResponse getUser () {
        return user;
    }

    public void setUser ( BasicUserResponse user ) {
        this.user = user;
    }

    public BasicClubResponse getClub () {
        return club;
    }

    public void setClub ( BasicClubResponse club ) {
        this.club = club;
    }
}
