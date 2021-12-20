package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;

public class ClubMemberResponse {
    private long id;
    private int attendedEventCount;
    private int gePoint;
    private UserResponse user;
    private BasicClubResponse club;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public int getAttendedEventCount () {
        return attendedEventCount;
    }

    public void setAttendedEventCount ( int attendedEventCount ) {
        this.attendedEventCount = attendedEventCount;
    }

    public int getGePoint () {
        return gePoint;
    }

    public void setGePoint ( int gePoint ) {
        this.gePoint = gePoint;
    }

    public UserResponse getUser () {
        return user;
    }

    public void setUser ( UserResponse user ) {
        this.user = user;
    }

    public BasicClubResponse getClub () {
        return club;
    }

    public void setClub ( BasicClubResponse club ) {
        this.club = club;
    }
}
